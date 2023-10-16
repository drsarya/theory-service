package com.baeldung.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import rating.library.FormulaRatingImpl;
import rating.library.HelloServiceImpl;

import java.io.IOException;

public class RatingServiceApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new FormulaRatingImpl())
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
