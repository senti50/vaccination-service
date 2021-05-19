package com.senti.grpc.vaccinationservice.vaccinationservice.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestClientAdapter {

    @GetMapping("checkforuser")
    public Boolean checkVaccinationForUser(@RequestParam String userId){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        com.senti.grpc.vaccinationservice.schema.VaccinationServiceGrpc.VaccinationServiceBlockingStub stub = com.senti.grpc.vaccinationservice.schema.VaccinationServiceGrpc.
                newBlockingStub(managedChannel);



            com.senti.grpc.vaccinationservice.schema.Vaccination.VaccinationResponse response = stub.checkIfReady(com.senti.grpc.vaccinationservice.schema.Vaccination.VaccinationRequest.newBuilder()
                    .setId(String.valueOf(userId))
                    .build());



        managedChannel.shutdown();
    return response.getVaccinationReady();
    }
}
