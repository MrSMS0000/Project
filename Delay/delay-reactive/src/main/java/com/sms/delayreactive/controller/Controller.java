package com.sms.delayreactive.controller;

import com.sms.delayreactive.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service){
        this.service = service;
    }

    @GetMapping("/{delay}")
    public Mono<String> getMessage(@PathVariable Integer delay){
        return service.getMessage(delay);
    }
}
