package com.sms.delaysynchronous.controller;

import com.sms.delaysynchronous.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service){
        this.service = service;
    }

    @GetMapping("/{delay}")
    public String getMessage(@PathVariable Integer delay){
        return service.getMessage(delay);
    }
}
