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
    public void  updateEnvironment(@RequestBody Environment environment, @PathVariable Long id){
        environmentService.updateEnvironment(id, environment);
    }

    @DeleteMapping("/environment/{id}")
    public void deleteEnvironment(@PathVariable Long id){
        environmentService.deleteEnvironment(id);
    }


}
