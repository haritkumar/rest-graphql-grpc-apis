package com.grpc;

import java.io.IOException;

import com.grpc.services.HelloServiceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("gRPC Server starting...");

    Server server = ServerBuilder.forPort(5000)
      .addService(new HelloServiceImp())
      .build();
    server.start();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Received Shutdown...");
      server.shutdown();
      System.out.println("UserServer Stopped");
    }));

    server.awaitTermination();
  }
}
