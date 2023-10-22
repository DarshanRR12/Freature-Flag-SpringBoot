package com.java.featureflag.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentService {
    @Autowired EnvironmentRepository environmentRepository;

    public List<Environment> getAllEnvironment() {
        List<Environment> environments = new ArrayList<>();
        environmentRepository.findAll().forEach(environments::add);
        return environments;
    }

    public Optional<Environment> getEnvironment(Long id){
        return environmentRepository.findById(id);
    }

    public void addEnvironment(Environment environment){
        environmentRepository.save(environment);
    }

    public void deleteEnvironment(Long id) {
        environmentRepository.deleteById(id);
    }

    public void updateEnvironment(Long id) {
        environmentRepository.save(id);
    }
}
