package com.minholim.KoreanNameGenerator.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class KoreanNameModel {

    List<KoreanLastName> lastNameList = new ArrayList<KoreanLastName>();

    List<KoreanFirstName> firstNameList = new ArrayList<KoreanFirstName>();

    public KoreanNameModel() {

        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://slayer:skek1004@cluster0.mddilon.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("koreannames");

        MongoCollection<Document> collection = database.getCollection("KoreanLastNames");

        // get all documents insert into lastNameList
        for (Document myDoc : collection.find()) {
            lastNameList.add(new KoreanLastName(myDoc.getString("LastName")));
        }

        MongoCollection<Document> firstNameCollection = database.getCollection("KoreanNames");

        // get all documents insert into firstNameList

        for (Document myDoc : firstNameCollection.find()) {
            // print them
            // System.out.println(myDoc.getString("FirstName"));
            // System.out.println(myDoc.getString("R_FirstName"));
            // System.out.println(myDoc.getDouble("Masculine:Feminine"));
            firstNameList.add(new KoreanFirstName(myDoc.getString("FirstName"),
                    myDoc.getString("R_FirstName"), myDoc.getDouble("Masculine:Feminine")));
        }

    }

    public List<KoreanLastName> getLastNameList() {
        return lastNameList;
    }

    // Get random KoreanLastName
    public KoreanLastName getRandomKoreanLastName() {
        return lastNameList.get((int) (Math.random() * lastNameList.size()));
    }

    // Get random KoreanFirstName
    public KoreanFirstName getRandomKoreanFirstName() {
        return firstNameList.get((int) (Math.random() * firstNameList.size()));
    }
}
