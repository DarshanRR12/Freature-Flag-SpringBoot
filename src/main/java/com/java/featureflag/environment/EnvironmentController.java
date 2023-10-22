package com.java.featureflag.environment;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EnvironmentController {

    @Autowired EnvironmentService environmentService;
    @Autowired
    private EnvironmentRepository environmentRepository;
    @GetMapping("/environment")
    public List<Environment> getAllEnvironment(){
        return environmentService.getAllEnvironment();
    }

    @GetMapping("/environment/{id}")
    public Optional<Environment> getEnvironment(@PathVariable Long id){
        return environmentService.getEnvironment(id);
    }

    @PostMapping("/environment")
    public void addEnvironment(@RequestBody Environment environment){
        environmentService.addEnvironment(environment);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/environment/{id}")
    public ResponseEntity<Environment> updateEnvironment(@RequestBody Environment environment, @PathVariable Long id){
        Environment environment1 = environmentRepository.findById(id).orElseThrow(() -> new RuntimeException("not found!"));
        environment1.setId(environment.getId());
        environment1.setName(environment.getName());
        environment1.setOwnerId(environment.getOwnerId());

        Environment updatedEnvi = environmentRepository.save(environment1);
        return ResponseEntity.ok(updatedEnvi);
    }

    @DeleteMapping("/environment/{id}")
    public void deleteEnvironment(@PathVariable Long id){
        environmentService.deleteEnvironment(id);
    }


}
