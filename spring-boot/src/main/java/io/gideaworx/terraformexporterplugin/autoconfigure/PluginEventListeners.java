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

import org.springframework.context.event.EventListener;

import org.springframework.boot.context.event.*;
import static io.gideaworx.terraformexporterplugin.Constants.*;
import net.devh.boot.grpc.server.event.*;

import java.util.Arrays;
import java.util.Map;

/**
 * Registers important event listeners in the plugin lifecycle
 */
public class PluginEventListeners {

  /**
   * When invoked by the CLI, the CLI invokes with environment variables that need to match a certain pattern.
   * Specifically, it sends a "magic cookie" defined by the CLI, that we must verify is valid. In addition,
   * it specifies the versions of the app protocol that it supports, and we must check that we are providing
   * a supported version
   * 
   * @param event The event indicating the application environment is ready to be checked
   */
  @EventListener
  public void onApplicationEnvironmentPrepared(ApplicationEnvironmentPreparedEvent event) {
    // When started by the CLI, it will send certain environment variables, so we
    // should check them here
    Map<String, String> appEnv = System.getenv();
    if (!appEnv.containsKey(MagicCookieKey)) {
      throw new IllegalStateException(String.format(
          "The environment variable %s is not set. This usually means the app was not started by the CLI (or the wrong version of the CLI).",
          MagicCookieKey));
    }

    String magicCookieVal = appEnv.get(MagicCookieKey);
    if (!MagicCookieValue.equals(magicCookieVal)) {
      throw new IllegalStateException(String.format(
          "Environment variable %s must be set to %s, but it was set to %s. This usually means the app was not started by the CLI (or the wrong version of the CLI)"));
    }

    if (!appEnv.containsKey(AcceptedProtocolsHeader)) {
      throw new IllegalStateException(String.format(
          "The environment variable %s is not set. This usually means the app was not started by the CLI (or the wrong version of the CLI).",
          AcceptedProtocolsHeader));
    }

    String allowedProtocols = appEnv.get(AcceptedProtocolsHeader);
    try {
      boolean supportsProtocol = Arrays.stream(allowedProtocols.split(","))
          .map(Integer::parseInt)
          .filter(p -> p == PluginAppProtocolVersion)
          .count() == 1;

      if (!supportsProtocol) {
        throw new IllegalStateException(
            String.format("This plugin uses protocol version %d, but the CLI only supports versions %s",
                PluginAppProtocolVersion, allowedProtocols));
      }
    } catch (NumberFormatException e) {
      throw new IllegalStateException(String.format(
          "The CLI sends the list of allowed protocols as a comma-separated list of ints in environment variable %s, but the plugin received %s",
          AcceptedProtocolsHeader, allowedProtocols), e);
    }
  }

  /**
   * Because the CLI only supports co-located plugins, it can capture the standard output stream, and relies on GRPC implementations
   * printing to stdout a string indicating the plugin library version, the plugin's app version, the networking type (either "unix"
   * for domain sockets or "tcp"), the address to send requests to (either the socket file or host:port) and the protocol ("grpc").
   * 
   * Because of this design decision on the part of the underlying plugin library for the CLI, it is <b><i>VITALLY IMPORTANT</i></b>
   * that your app not write ANYTHING to System.out except this string. Make sure you either set banner-mode to "off" or "log" and
   * ensure that any logs created write to System.err.
   * 
   * @param event The event indicating that the GRPC server is listening in order to print the connection info
   */
  @EventListener
  public void onServerStarted(GrpcServerStartedEvent event) {
    String networkType = "tcp";
    String networkAddr = event.getAddress();
    if (event.getPort() > 0) {
      networkAddr += ":" + Integer.toString(event.getPort());
    }

    if (networkAddr.startsWith("unix:")) {
      networkAddr = networkAddr.substring("unix:".length());
      networkType = "unix";
    }

    System.out.printf("%d|%d|%s|grpc\n", PluginCoreProtocolVersion, PluginAppProtocolVersion, networkType, networkAddr);
  }
}
