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

public final class Exporter {
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

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface Export {
  }

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