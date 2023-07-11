package com.sms.databasereactivefixed.controller;

import com.sms.databasereactivefixed.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.sms.databasereactivefixed.model.Entity;


@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service){
        this.service = service;
    }
    @GetMapping("/{id}")
    public Mono<Entity> getMessage(@PathVariable String id){
        return service.getMessage(id);
    }

    // nothing to do with benchmark, just to add some data in database
    @PostMapping("/add")
    public Mono<Entity> addEntity(@RequestBody Entity entity){
        return service.addEntity(entity);
    }
}