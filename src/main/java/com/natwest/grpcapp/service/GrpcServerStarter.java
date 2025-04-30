package com.natwest.grpcapp.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class GrpcServerStarter {

    private Server server;

    @PostConstruct
    public void start() throws Exception {
        server = ServerBuilder.forPort(9090)
                .addService(new HelloServiceImpl())
                .build()
                .start();

        System.out.println("✅ gRPC Server started on port 9090");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("🛑 Shutting down gRPC server...");
            server.shutdown();
        }));
    }
}
