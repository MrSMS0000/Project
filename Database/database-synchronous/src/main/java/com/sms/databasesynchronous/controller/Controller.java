package com.sms.databasesynchronous.controller;

import com.sms.databasesynchronous.model.Entity;
import com.sms.databasesynchronous.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Entity getMessage(@PathVariable String id) {
        return service.getMessage(id);
    }

}