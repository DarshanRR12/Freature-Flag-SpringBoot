package com.java.featureflag.environment;

import org.springframework.data.repository.CrudRepository;

public interface EnvironmentRepository extends CrudRepository<Environment, Long> {
    void save(Long id);
}
