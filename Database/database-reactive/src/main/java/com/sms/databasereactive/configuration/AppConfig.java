package com.sms.databasereactive.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class AppConfig {
    public static final String dataBaseName = "Testing";
    public static final String collectionName = "time";
    private static final String connectionString =
            //"mongodb://localhost:27017";          // to connect locally
            "mongodb+srv://admin:12345@springmongocluster.xbfbl9p.mongodb.net/?retryWrites=true&w=majority";        // to connect atlas
    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(connectionString);
    }
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient){
        return new ReactiveMongoTemplate(mongoClient(), AppConfig.dataBaseName);
    }

}
