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
package io.gideaworx.terraformexporterplugin;

/**
 * Constants used in the project
 */
public final class Constants {
  /**
   * Defined by the CLI, and must be kept in sync to work with the latest versions of the CLI
   */
  public static final String MagicCookieKey = "TF_EXPORTER";

  /**
   * Defined by the CLI, and must be kept in sync to work with the latest versions of the CLI
   */
  public static final String MagicCookieValue = "exporter-plugin";

  /**
   * The environment variable where the CLI identifies the supported plugin versions
   */
  public static final String AcceptedProtocolsHeader = "PLUGIN_PROTOCOL_VERSIONS";

  /**
   * The current version of the plugin protocol supported by the CLI
   */
  public static final int PluginCoreProtocolVersion = 1;

  /**
   * The current version of the app protocol provided by this plugin
   */
  public static final int PluginAppProtocolVersion = 3;
}
