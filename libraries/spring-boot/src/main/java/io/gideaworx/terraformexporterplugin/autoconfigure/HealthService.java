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

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import io.grpc.health.v1.HealthCheckRequest;
import io.grpc.health.v1.HealthCheckResponse;
import io.grpc.health.v1.HealthCheckResponse.ServingStatus;
import io.grpc.health.v1.HealthGrpc.HealthImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Implements the standard GRPC v1 health service, which is required by the terraform export CLI for plugins
 * not written in Go.
 */
@ConditionalOnMissingBean
@GrpcService
public class HealthService extends HealthImplBase {

  private final HealthCheckResponse response;

  public HealthService() {
    response = HealthCheckResponse.newBuilder().setStatus(ServingStatus.SERVING).build();
  }

  /** 
   * Reports that the plugin is currently serving requests
   */
  @Override
  public void check(HealthCheckRequest request, StreamObserver<HealthCheckResponse> responseObserver) {
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  /** 
   * Reports that the plugin is currently serving requests, but streaming
   */
  @Override
  public void watch(HealthCheckRequest request, StreamObserver<HealthCheckResponse> responseObserver) {
    responseObserver.onNext(response);
  }
}
