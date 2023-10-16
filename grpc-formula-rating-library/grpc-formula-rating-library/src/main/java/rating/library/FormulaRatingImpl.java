package rating.library;

import generated.rating.library.FormulaRatingRequest;
import generated.rating.library.FormulaRatingResponse;
import generated.rating.library.FormulaRatingServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Random;

public class FormulaRatingImpl extends FormulaRatingServiceGrpc.FormulaRatingServiceImplBase {
    private final Random random = new Random();

    @Override
    public void getFormulaRating(FormulaRatingRequest request, StreamObserver<FormulaRatingResponse> responseObserver) {
        FormulaRatingResponse response = FormulaRatingResponse.newBuilder()
                .setFormulaId(request.getFormulaId())
                .setRating(Math.abs(random.nextInt()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
