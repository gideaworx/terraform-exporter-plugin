/*
 * Copyright (c) 2023-2023 Josh Ghiloni <ghiloni@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.gideaworx.terraformexporterplugin.autoconfigure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

import io.gideaworx.terraformexporterplugin.CommandInfo;
import io.gideaworx.terraformexporterplugin.ExportCommandHelp;
import io.gideaworx.terraformexporterplugin.TerraformExporter;
import io.gideaworx.terraformexporterplugin.Version;
import lombok.Setter;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;

@Configuration
@AutoConfigureBefore(GrpcServerAutoConfiguration.class)
@AutoConfigureAfter(ExporterConfigurationProperties.class)
@Setter
public final class PluginAutoConfiguration implements ApplicationContextAware {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private ExporterConfigurationProperties config;

  private Method exportMethodTemplate;

  public PluginAutoConfiguration() {
    Method[] ms = TerraformExporter.class.getDeclaredMethods();
    for (Method m : ms) {
      if ("export".equals(m.getName())) {
        exportMethodTemplate = m;
        break;
      }
    }
  }

  @ConditionalOnMissingBean
  @Bean
  public Version pluginVersion() {
    if (config.getVersion() != null) {
      return config.getVersion();
    }

    return Version.DEFAULT;
  }

  @ConditionalOnMissingBean
  @Conditional(ConditionalOnCommandsRegistered.class)
  @Bean
  public Map<String, Exporter.CompleteExportCommand> registeredCommands() {
    Map<String, Exporter.CompleteExportCommand> commands = new LinkedHashMap<String, Exporter.CompleteExportCommand>();

    Map<String, Object> registeredBeans = new LinkedHashMap<String, Object>();
    registeredBeans.putAll(applicationContext.getBeansOfType(TerraformExporter.class));
    registeredBeans.putAll(applicationContext.getBeansWithAnnotation(Exporter.Command.class));
    
    for (Map.Entry<String, Object> entry : registeredBeans.entrySet()) {
      commands.put(entry.getKey(), normalizeCommand(entry.getKey(), entry.getValue()));
    }

    return commands;
  }

  private Exporter.CompleteExportCommand normalizeCommand(String beanName, Object bean) {
    Method exportMethod = null;
    Method helpMethod = null;
    CommandInfo info = null;

    Method[] beanMethods = bean.getClass().getMethods();

    // first, calculate the export method, if necessary
    if (!(bean instanceof TerraformExporter)) {
      for (Method m : beanMethods) {
        Exporter.Export a = m.getAnnotation(Exporter.Export.class);
        if (a != null) {
          // if the method is annotated, ensure that it is public, concrete, and has the
          // correct signature
          int mod = m.getModifiers();
          if (Modifier.isPublic(mod) && !Modifier.isAbstract(mod)) {
            if (m.getReturnType().equals(exportMethodTemplate.getReturnType())) {
              boolean found = true;
              Class<?>[] provided = m.getParameterTypes();
              Class<?>[] expected = exportMethodTemplate.getParameterTypes();
              if (provided.length == expected.length) {
                for (int i = 0; i < expected.length; i++) {
                  if (!expected[i].equals(provided[i])) {
                    found = false;
                    break;
                  }
                }

                if (found) {
                  exportMethod = m;
                  break;
                }
              }
            }
          }
        }
      }
    }

    // now, calculate the help method, if necessary
    if (!(bean instanceof ExportCommandHelp)) {
      for (Method m : beanMethods) {
        Exporter.Help a = m.getAnnotation(Exporter.Help.class);
        if (a != null) {
          // if the method is annotated, ensure that it is public, concrete, and has the
          // correct signature
          int mod = m.getModifiers();
          if (Modifier.isPublic(mod) && !Modifier.isAbstract(mod)) {
            if (String.class.equals(m.getReturnType()) && m.getParameterTypes().length == 0) {
              helpMethod = m;
              break;
            }
          }
        }
      }
    }

    /*
     * Now, get the info method. We first see if it provides a public, concrete
     * method named "info"that accepts no arguments and returns a CommandInfo
     * record. If it doesn't, then we get the info from the bean's @Command
     * annotation, if it exists. Then, we look from overrides from Spring
     * properties. If any properties are not set, we create sensible defaults
     */
    try {
      Method infoMethod = bean.getClass().getMethod("info");
      int mod = infoMethod.getModifiers();
      if (Modifier.isPublic(mod) && !Modifier.isAbstract(mod)) {
        info = Optional.ofNullable(infoMethod.invoke(infoMethod))
            .filter(CommandInfo.class::isInstance)
            .map(CommandInfo.class::cast)
            .get();
      }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
    }

    if (info == null) {
      String name = beanName;
      String description = "";
      String summary = "";
      Version version = Version.DEFAULT;

      Exporter.Command a = bean.getClass().getAnnotation(Exporter.Command.class);
      if (a != null) {
        if (a.name() != null && a.name().trim().length() > 0) {
          name = a.name().trim();
        }

        if (a.description() != null) {
          description = a.description().trim();
        }

        if (a.summary() != null) {
          summary = a.summary().trim();
        }

        version = Version.fromString(a.version().trim());
      }
      
      Map<String, CommandInfo> commandConfigs = config.getCommands();
      if (commandConfigs.containsKey(name)) {
        CommandInfo fromConfig = commandConfigs.get(name);
        if (fromConfig.description() != null) {
          description = fromConfig.description();
        }

        if (fromConfig.summary() != null) {
          description = fromConfig.summary();
        }

        if (fromConfig.version() != null) {
          version = fromConfig.version();
        }
      }
      
      info = new CommandInfo(name, description, summary, version);
    }

    return new Exporter.SynthesizedExportCommand(bean, info, exportMethod, helpMethod);
  }

  public static final class ConditionalOnCommandsRegistered implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      Map<?, ?> ibeans = context.getBeanFactory().getBeansOfType(TerraformExporter.class);
      if (ibeans != null && ibeans.size() == 0) {
        Map<?, ?> abeans = context.getBeanFactory().getBeansWithAnnotation(Exporter.Command.class);
        return abeans.size() > 0;
      }

      return true;
    }
  }
}
