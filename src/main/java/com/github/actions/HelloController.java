package com.github.actions;

import com.github.actions.entity.Greeting;
import com.github.actions.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private GreetingRepository repository;

    @RequestMapping("/")
    String hello() {
        return "Welcome!!! Github Actions Training with Docker and Kubernetes";
    }

    @GetMapping("/fetchGreeting/{id}")
    public ResponseEntity<Greeting> showHome(@PathVariable Integer id) {

        Greeting dockerGreeting = repository.findById(id).orElse(new Greeting("Not Found 😕"));
        if (dockerGreeting != null) {
            return ResponseEntity.ok(dockerGreeting); // Returns 200 OK with user object
        } else {
            return ResponseEntity.notFound().build(); // Returns 404 Not Found
        }
    }

}