package com.senti.grpc.vaccinationservice.vaccinationservice.client;

import com.senti.grpc.vaccinationservice.schema.Vaccination;
import com.senti.grpc.vaccinationservice.schema.VaccinationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcVaccinationServiceClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        VaccinationServiceGrpc.VaccinationServiceBlockingStub stub = VaccinationServiceGrpc.
                newBlockingStub(managedChannel);


        for (int i = 0; i <= 100; i++) {
            Vaccination.VaccinationResponse response = stub.checkIfReady(Vaccination.VaccinationRequest.newBuilder()
                    .setId(String.valueOf(i))
                    .build());

            System.out.println("User ID: " + i + ", vaccinationReady: " + response.getVaccinationReady());
        }
        managedChannel.shutdown();
    }
}
