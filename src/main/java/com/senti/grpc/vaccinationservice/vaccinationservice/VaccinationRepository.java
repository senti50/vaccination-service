package com.senti.grpc.vaccinationservice.vaccinationservice;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class VaccinationRepository {
    private Map<String, Boolean> repository;

    public Map<String, Boolean> getRepository() {
        return repository;
    }

    @PostConstruct
    public void initRepository(){
        repository = new HashMap<>();
        for(int n= 0; n <= 100; n++){
            repository.put(String.valueOf(n), n % 2 == 0 ? false : true);
        }
    }
}
