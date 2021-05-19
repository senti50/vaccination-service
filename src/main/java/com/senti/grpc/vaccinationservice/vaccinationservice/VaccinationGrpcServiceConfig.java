package com.senti.grpc.vaccinationservice.vaccinationservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class VaccinationGrpcServiceConfig {

    private final VaccinationServiceImpl vaccinationService;

    public VaccinationGrpcServiceConfig(VaccinationServiceImpl vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @PostConstruct
    public void init() throws IOException {
        Server server= ServerBuilder.forPort(8081)
                .addService(vaccinationService)
                .build()
                .start();

    }
}
