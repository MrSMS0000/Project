package com.sms.databasesynchronousfixed.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {
    public static final String dataBaseName = "Testing";
    public static final String collectionName = "time";
    private static final String connectionString =
            //"mongodb://localhost:27017";          // to connect locally
            "mongodb+srv://admin:12345@springmongocluster.xbfbl9p.mongodb.net/?retryWrites=true&w=majority";        // to connect atlas
    @Bean
    public MongoClient mongoClient(){
        MongoClientSettings settings = MongoClientSettings.builder()
                // to increase number of connection to mongodb from 100 to 200
                .applyToConnectionPoolSettings(builder -> builder.maxSize(200))
                .applyConnectionString(new ConnectionString(connectionString))
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate reactiveMongoTemplate(MongoClient mongoClient){
        return new MongoTemplate(mongoClient(), AppConfig.dataBaseName);
    }
}