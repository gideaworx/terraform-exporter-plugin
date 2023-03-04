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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import io.gideaworx.terraformexporterplugin.grpc.*;
import io.gideaworx.terraformexporterplugin.util.GrpcUtils;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.*;

@GrpcService
@ConditionalOnBean(name = {"registeredCommands"})
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class PluginService extends ExportPluginGrpc.ExportPluginImplBase {

  @Autowired
  @Qualifier("registeredCommands")
  private final Map<String, Exporter.CompleteExportCommand> registeredCommands;

  @Autowired
  @Qualifier("pluginVersion")
  private final io.gideaworx.terraformexporterplugin.Version pluginVersion;

  @Override
  public void export(PluginRequest request, StreamObserver<ExportResponse> responseObserver) {
    try {
      Exporter.CompleteExportCommand command = getCommand(request.getName());
      Iterable<io.gideaworx.terraformexporterplugin.ImportDirective> directives = command.export(request.getRequest().getOutputDirectory(), request.getRequest().getSkipProviderOutput(), request.getRequest().getPluginArgsList());
      
      ExportResponse.Builder responseBuilder = ExportResponse.newBuilder();
      for (io.gideaworx.terraformexporterplugin.ImportDirective nd : directives) {
        responseBuilder.addDirectives(GrpcUtils.toGRPC(nd));
      }

      responseObserver.onNext(responseBuilder.build());
    } catch (Throwable t) {
      responseObserver.onError(t);
    } finally {
      responseObserver.onCompleted();
    }
  }

  @Override
  public void help(SingleString request, StreamObserver<SingleString> responseObserver) {
    try {
      Exporter.CompleteExportCommand command = getCommand(request.getValue());
      String returnValue = command.help();

      responseObserver.onNext(SingleString.newBuilder().setValue(returnValue).build());
    } catch (Throwable t) {
      responseObserver.onError(t);
    } finally {
      responseObserver.onCompleted();
    }
  }

  @Override
  public void info(Empty request, StreamObserver<PluginInfo> responseObserver) {
    PluginInfo.Builder b = PluginInfo.newBuilder();

    io.gideaworx.terraformexporterplugin.Version v = pluginVersion;
    if (v == null) {
      v = io.gideaworx.terraformexporterplugin.Version.DEFAULT;
    }

    b.setVersion(GrpcUtils.toGRPC(v));

    for (Exporter.CompleteExportCommand cmd : registeredCommands.values()) {
      b.addProvides(GrpcUtils.toGRPC(cmd.info()));
    }

    responseObserver.onNext(b.build());
    responseObserver.onCompleted();
  }

  private Exporter.CompleteExportCommand getCommand(String name) {
    if (registeredCommands.containsKey(name)) {
      return registeredCommands.get(name);
    }

    throw new IllegalArgumentException(name + " is not a registered Terraform Exporter command");
  }
}
  
