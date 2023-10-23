package com.baeldung.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import rating.library.FormulaRatingImpl;

import java.io.IOException;

public class RatingServiceApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8101)
                .addService(new FormulaRatingImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
