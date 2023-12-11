package com.example.theoryservice.service;

import generated.rating.library.FormulaRatingRequest;
import generated.rating.library.FormulaRatingResponse;
import generated.rating.library.FormulaRatingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class GrpcRatingClient {
    private final ManagedChannel channel;

    public GrpcRatingClient() {
        this.channel = ManagedChannelBuilder.forAddress("localhost", 8101)
                .usePlaintext()
                .build();
    }

    public FormulaRatingResponse getFormulaRating(int formulaId) {
        FormulaRatingServiceGrpc.FormulaRatingServiceBlockingStub stub
                = FormulaRatingServiceGrpc.newBlockingStub(channel);
        return stub.getFormulaRating(FormulaRatingRequest.newBuilder()
                .setFormulaId(formulaId)
                .build());
    }
}
