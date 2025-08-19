package com.github.actions;

import com.github.actions.entity.Greeting;
import com.github.actions.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/fetchGreeting")
    public String showHome(Model model) {
        Greeting dockerGreeting = repository.findById(1).orElse(new Greeting("Not Found 😕"));
        model = model.addAttribute("name", dockerGreeting.getName());
        return "home";
    }

}