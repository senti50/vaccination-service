package com.senti.grpc.vaccinationservice.vaccinationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VaccinationRepositoryRestController {

    private final VaccinationRepository vaccinationRepository;

    public VaccinationRepositoryRestController(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    @GetMapping("/repository")
    public Map<String,Boolean> viewRepositoryData(){
        return vaccinationRepository.getRepository();
    }
}
