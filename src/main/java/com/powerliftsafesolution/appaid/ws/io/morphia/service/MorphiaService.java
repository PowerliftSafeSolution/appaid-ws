package com.powerliftsafesolution.appaid.ws.io.morphia.service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public final class MorphiaService {
    private static MorphiaService INSTANCE;

    private MongoClient mongoClient;
    private Morphia morphia;
    private Datastore datastore;

    private MorphiaService(){
        this.mongoClient = new MongoClient(new MongoClientURI(
                "mongodb://Powerlift:H7sgTzwEt4gcKGjw@ds151180.mlab.com:51180/appaid"));
        this.morphia = new Morphia();
        this.datastore = morphia.createDatastore(mongoClient,"appaid");
    }

    public void closeConnection(){
        this.mongoClient.close();
        this.morphia = null;
        this.datastore = null;
    }

    public static MorphiaService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MorphiaService();
        }
        return INSTANCE;
    }

    public Datastore getDataStore(){
        return this.datastore;
    }
}
