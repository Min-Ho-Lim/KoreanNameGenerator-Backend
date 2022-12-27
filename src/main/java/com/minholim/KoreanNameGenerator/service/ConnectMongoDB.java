package com.minholim.KoreanNameGenerator.service;

import org.springframework.stereotype.Service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class ConnectMongoDB {

    private final String databaseName = "koreannames";
    private MongoDatabase database;

    private ConnectionString gConnectionString() {
        // get mongodb.username
        String username = System.getProperty("mongodb.username");
        // get mongodb.password
        String password = System.getProperty("mongodb.password");

        if (username == null || password == null) {
            throw new RuntimeException("MongoDB username or password is not set");
        }

        return new ConnectionString(
                "mongodb+srv://" + username + ":" + password
                        + "@cluster0.mddilon.mongodb.net/?retryWrites=true&w=majority");
    }

    private Boolean isDatabaseConnected() {
        if (database == null) {
            return false;
        }
        return true;
    }

    public void connectMongoDB() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(gConnectionString())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase(databaseName);
    }

    public MongoCollection getCollection(String collectionName) {
        if (!isDatabaseConnected()) {
            connectMongoDB();
        }
        return database.getCollection(collectionName);
    }
}
