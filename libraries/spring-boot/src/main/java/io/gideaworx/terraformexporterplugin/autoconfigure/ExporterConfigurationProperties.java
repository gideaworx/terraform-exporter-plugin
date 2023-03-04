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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

import io.gideaworx.terraformexporterplugin.*;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;

/**
 * These can be set via any standard Spring Boot application property-setting mechanisms.
 */
@Configuration
@ConfigurationProperties(prefix = "terraform-exporter-plugin")
@Data
public class ExporterConfigurationProperties {
  /**
   * Can be set in either a string or object form. That is, you can set
   * <pre>
   * terraform-exporter-plugin:
   *   version: "1.2.3"
   * </pre>
   * 
   * or
   * 
   * <pre>
   * terraform-exporter-plugin:
   *   version:
   *     major: 1
   *     minor: 2
   *     patch: 3
   *     pre: "" # optional
   *     buildMetadata: "" # optional
   * </pre>
   * 
   * If not set, will default to <code>0.0.0-dev</code>
   */
  private Version version;
  
  /**
   * For any commands not registered via {@link io.gideaworx.terraformexporterplugin.autoconfigure.Exporter.Command},
   * info MUST be set here or via an <code>info</code> method. Information here will take precedence over either method
   * of specifying a command's info in code. The name field will be ignored, and the key of this map must match a
   * registered command's name (either its bean name or the name specified in its <code>@Command</code> annotation)
   * for it to apply.
   */
  private Map<String, CommandInfo> commands;

  @Component
  @ConfigurationPropertiesBinding
  public static class VersionConverter implements Converter<String, Version> {

    @Override
    public Version convert(String source) {
      return Version.fromString(source);
    }
  }
}
