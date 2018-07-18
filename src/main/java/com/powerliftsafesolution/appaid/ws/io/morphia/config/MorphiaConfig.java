package com.powerliftsafesolution.appaid.ws.io.morphia.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mongodb-appaid-live.properties")
public class MorphiaConfig {

    @Value("${mongodb.username}")
    private String userName;
    @Value("${mongodb.password}")
    private String password;
    @Value("${mongodb.dbUrl}")
    private String dbUrl;
    @Value("${mongodb.dbName}")
    private String dbName;

    public MorphiaConfig() {
    }

    private Morphia morphia(){
        final Morphia morphia = new Morphia();

        morphia.mapPackage("com.powerliftsafesolution.appaid.ws.io.morphia.entity");

        return morphia;
    }

    private String buildUrl(){
        return "mongodb://" + this.userName + ":" + this.password + "@" + this.dbUrl + "/" + this.dbName;
    }

    @Bean
    public Datastore getDataStore() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(this.buildUrl()));
        Datastore dataStore = this.morphia().createDatastore(mongoClient, this.dbName);
        return dataStore;
    }
}
