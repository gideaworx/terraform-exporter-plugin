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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import io.gideaworx.terraformexporterplugin.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * A wrapper class for annotations used by the project.
 */
public abstract class Exporter {

  /**
   * A class annotated with <code>@Command</code> will be registered as a Spring
   * bean capable of responding to terraform export CLI requests to export data.
   * 
   * To be an exporter, a class annotated with <code>@Command</code> must either
   * a. Have a method annotated with <code>@{@link io.gideaworx.terraformexporterplugin.autoconfigure.Exporter.Export}</code>
   *    that conforms to the signature <code>public {@link java.lang.Iterable}&lt;{@link io.gideaworx.terraformexporterplugin.ImportDirective}&gt; methodName({@link java.lang.String}, boolean, {@link java.lang.Iterable}&lt;{@link java.lang.String}&gt;)</code> and
   * b. Have a method annotated with <code>@{@link io.gideaworx.terraformexporterplugin.autoconfigure.Exporter.Help}</code>
   *    that conforms to the signature <code>public {@link java.lang.String} methodName()</code> OR
   * c. Implement {@link io.gideaworx.terraformexporterplugin.TerraformExporter} and {@link io.gideaworx.terraformexporterplugin.ExportCommandHelp}
   * 
   * If you choose to register your command via more traditional methods, then you must use option C above.
   * 
   * The parameters on this annotation describe the command, which is used by the CLI. If you do not use this annotation, you must either implement a method
   * that accepts no arguments and returns a {@link io.gideaworx.terraformexporterplugin.CommandInfo} or add configuration properties described in
   * {@link io.gideaworx.terraformexporterplugin.autoconfigure.ExporterConfigurationProperties}
   * 
   * @see io.gideaworx.terraformexporterplugin.TerraformExporter
   */
  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @Inherited
  @Component
  public @interface Command {
    String version() default "0.0.0-dev";

    String name() default "";

    String description() default "";

    String summary() default "";
  }

  /**
   * Registers a method as an command's export method. To use this, the method annotated must be part of a class annotated with
   * {@link io.gideaworx.terraformexporterplugin.autoconfigure.Exporter.Command}
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface Export {
  }

  /**
   * Registers a method as an command's help method. To use this, the method annotated must be part of a class annotated with
   * {@link io.gideaworx.terraformexporterplugin.autoconfigure.Exporter.Command}
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface Help {
  }

  interface CompleteExportCommand extends TerraformExporter, ExportCommandHelp {
    public CommandInfo info();
  }

  @AllArgsConstructor
  @EqualsAndHashCode(callSuper = false)
  static class SynthesizedExportCommand implements CompleteExportCommand {
    private final Object receiver;
    private final CommandInfo info;
    private final Method exportMethod;
    private final Method helpMethod;

    @Override
    @SuppressWarnings({ "unchecked" })
    public Iterable<ImportDirective> export(String outputDirectory, boolean skipProviderOutput,
        Iterable<String> arguments) {

      if (receiver instanceof TerraformExporter tfe) {
        return tfe.export(outputDirectory, skipProviderOutput, arguments);
      }

      try {
        Object o = exportMethod.invoke(receiver, outputDirectory, skipProviderOutput, arguments);
        return (Iterable<ImportDirective>) o;
      } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public String help() {
      if (receiver instanceof ExportCommandHelp ech) {
        return ech.help();
      }

      try {
        Object o = helpMethod.invoke(receiver);
        if (o == null) {
          return null;
        }

        return o.toString();
      } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CommandInfo info() {
      return info;
    }
  }
}