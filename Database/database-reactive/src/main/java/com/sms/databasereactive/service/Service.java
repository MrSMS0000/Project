package com.sms.databasereactive.service;

import com.sms.databasereactive.configuration.AppConfig;
import com.sms.databasereactive.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@org.springframework.stereotype.Service
public class Service {
    private final ReactiveMongoTemplate template;
    @Autowired
    public Service(ReactiveMongoTemplate template){
        this.template = template;
    }

    public Mono<Entity> getMessage(String id) {
        return template.findById(id, Entity.class, AppConfig.collectionName);
    }

    // nothing to do with benchmark, just to add some data in database
    public Mono<Entity> addEntity(Entity entity){
        return template.save(entity,AppConfig.collectionName);
    }
}
