package com.sms.databasesynchronousfixed.service;

import com.sms.databasesynchronousfixed.configuration.AppConfig;
import com.sms.databasesynchronousfixed.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

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
