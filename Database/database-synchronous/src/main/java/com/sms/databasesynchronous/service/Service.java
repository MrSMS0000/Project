package com.sms.databasesynchronous.service;

import com.sms.databasesynchronous.configuration.AppConfig;
import com.sms.databasesynchronous.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@org.springframework.stereotype.Service
public class Service {
    private final MongoTemplate template;
    @Autowired
    public Service(MongoTemplate template){
        this.template = template;
    }

    public Entity getMessage(String id){
        return template.findById(id, Entity.class, AppConfig.collectionName);
    }

}
