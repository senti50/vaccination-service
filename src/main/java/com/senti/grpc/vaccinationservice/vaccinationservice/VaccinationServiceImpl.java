package com.senti.grpc.vaccinationservice.vaccinationservice;


import com.senti.grpc.vaccinationservice.schema.Vaccination.VaccinationRequest;
import com.senti.grpc.vaccinationservice.schema.Vaccination.VaccinationResponse;
import org.springframework.stereotype.Service;

import static com.senti.grpc.vaccinationservice.schema.VaccinationServiceGrpc.*;

@Service
public class VaccinationServiceImpl extends VaccinationServiceImplBase {

    private final VaccinationRepository vaccinationRepository;

    public VaccinationServiceImpl(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    public void checkIfReady(VaccinationRequest request,
                             io.grpc.stub.StreamObserver<VaccinationResponse> responseObserver) {

        Boolean vaccinationReady = vaccinationRepository.getRepository().get(request.getId());

        VaccinationResponse response = VaccinationResponse.newBuilder()
                .setVaccinationReady(vaccinationReady)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}