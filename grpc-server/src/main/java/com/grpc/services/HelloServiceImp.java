package com.grpc.services;


import com.grpc.HelloRequest;
import com.grpc.HelloResponse;
import com.grpc.HelloServiceGrpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImp extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void greet(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        responseObserver
                .onNext(HelloResponse
                        .newBuilder()
                        .setGreeting("Hello  " + request.getName())
                        .build());

        responseObserver.onCompleted();
    }
}