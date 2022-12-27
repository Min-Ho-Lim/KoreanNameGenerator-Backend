package com.minholim.KoreanNameGenerator.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.minholim.KoreanNameGenerator.service.ConnectMongoDB;
import com.mongodb.client.MongoCollection;

@Component
public class KoreanNameModel {

    List<KoreanLastName> lastNameList = new ArrayList<KoreanLastName>();

    List<KoreanFirstName> firstNameList = new ArrayList<KoreanFirstName>();

    public KoreanNameModel() {

        ConnectMongoDB connectMongoDB = new ConnectMongoDB();

        MongoCollection<Document> collection = connectMongoDB.getCollection("KoreanLastNames");

        // get all documents insert into lastNameList
        for (Document myDoc : collection.find()) {
            lastNameList.add(new KoreanLastName(myDoc.getString("LastName"),
                    myDoc.getString("R_LastName")));
        }

        MongoCollection<Document> firstNameCollection = connectMongoDB.getCollection("KoreanNames");

        // get all documents insert into firstNameList
        for (Document myDoc : firstNameCollection.find()) {
            firstNameList.add(new KoreanFirstName(myDoc.getString("FirstName"),
                    myDoc.getString("R_FirstName"), myDoc.getDouble("Masculine:Feminine")));
        }

    }

    public List<KoreanLastName> getLastNameList() {
        return lastNameList;
    }

    // Get random KoreanLastName
    public KoreanLastName getRandomKoreanLastName(int popularity) {
        if (popularity >= 0 && popularity <= lastNameList.size()) {
            return lastNameList.get((int) (Math.random() * popularity));
        }
        throw new IllegalArgumentException("popularity must be between 0 and " + lastNameList.size());
    }

    // Get random KoreanFirstName
    public KoreanFirstName getRandomKoreanFirstName(int popularity) {
        if (popularity >= 0 && popularity <= firstNameList.size()) {
            return firstNameList.get((int) (Math.random() * popularity));
        }
        throw new IllegalArgumentException("popularity must be between 0 and " + firstNameList.size());
    }

    // Create random full Korean Name
    public String getRandomKoreanName(int LastNamePopularity, int FirstNamePopularity) {
        return getRandomKoreanLastName(LastNamePopularity).getK_LastName() + " "
                + getRandomKoreanFirstName(FirstNamePopularity).getK_firstName();
    }

    // Create random full Korean Name
    public String getRandomRomanizedKoreanName(int LastNamePopularity, int FirstNamePopularity) {
        return getRandomKoreanLastName(LastNamePopularity).getE_LastName() + " "
                + getRandomKoreanFirstName(FirstNamePopularity).getE_firstName();
    }

    //
    public KoreanFullName getKoreanFullName(int LastNamePopularity, int FirstNamePopularity) {
        return new KoreanFullName(getRandomKoreanFirstName(FirstNamePopularity),
                getRandomKoreanLastName(LastNamePopularity));
    }

}
