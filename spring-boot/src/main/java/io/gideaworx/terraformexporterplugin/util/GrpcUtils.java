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
package io.gideaworx.terraformexporterplugin.util;

import lombok.NonNull;
import io.gideaworx.terraformexporterplugin.*;

public final class GrpcUtils {
  public static io.gideaworx.terraformexporterplugin.grpc.Version toGRPC(@NonNull Version v) {
    return io.gideaworx.terraformexporterplugin.grpc.Version.newBuilder()
        .setMajor(v.major()).setMinor(v.minor()).setPatch(v.patch()).setPre(v.pre()).setBuildMetadata(v.buildMetadata())
        .build();
  }

  public static io.gideaworx.terraformexporterplugin.grpc.CommandInfo toGRPC(@NonNull CommandInfo info) {
    return io.gideaworx.terraformexporterplugin.grpc.CommandInfo.newBuilder()
        .setName(info.name()).setDescription(info.description()).setSummary(info.summary())
        .setVersion(toGRPC(info.version())).build();
  }

  public static io.gideaworx.terraformexporterplugin.grpc.ImportDirective toGRPC(@NonNull ImportDirective directive) {
    return io.gideaworx.terraformexporterplugin.grpc.ImportDirective.newBuilder()
        .setResource(directive.resource()).setName(directive.name()).setID(directive.id()).build();
  }
}
