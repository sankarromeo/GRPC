package com.natwest.grpcapp.service;

import hello.HelloRequest;
import hello.HelloResponse;
import hello.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GrpcClientCaller implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder()
                .setName("gRPC POC with grpc-services")
                .build();

        HelloResponse response = stub.sayHello(request);

        System.out.println("✅ Response from gRPC server: " + response.getMessage());

        channel.shutdown();
    }
}
