package rating.library;


import generated.rating.library.FormulaRatingRequest;
import generated.rating.library.FormulaRatingResponse;
import generated.rating.library.FormulaRatingServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class FormulaRatingImpl extends FormulaRatingServiceGrpc.FormulaRatingServiceImplBase {
    private final Map<Integer, Long> formulaIdToRating = new HashMap<>();

    @Override
    public void getFormulaRating(FormulaRatingRequest request, StreamObserver<FormulaRatingResponse> responseObserver) {
        Long formulaRating = formulaIdToRating.get(request.getFormulaId());
        FormulaRatingResponse response = FormulaRatingResponse.newBuilder()
                .setFormulaId(request.getFormulaId())
                .setRating(formulaRating == null ? 0 : formulaRating)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addRating(FormulaRatingRequest request, StreamObserver<FormulaRatingResponse> responseObserver) {
        formulaIdToRating.putIfAbsent(request.getFormulaId(), 0L);
        Long rating = formulaIdToRating.merge(request.getFormulaId(), 1L, Long::sum);

        FormulaRatingResponse response = FormulaRatingResponse.newBuilder()
                .setFormulaId(request.getFormulaId())
                .setRating(rating)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
