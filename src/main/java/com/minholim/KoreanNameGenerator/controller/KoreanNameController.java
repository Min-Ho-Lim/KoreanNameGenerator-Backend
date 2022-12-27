package com.minholim.KoreanNameGenerator.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minholim.KoreanNameGenerator.model.KoreanFirstName;
import com.minholim.KoreanNameGenerator.model.KoreanLastName;
import com.minholim.KoreanNameGenerator.model.KoreanNameModel;

@RestController
public class KoreanNameController {

    private KoreanNameModel koreanNameModel = new KoreanNameModel();

    @GetMapping("/getRandomKoreanLastName")
    public KoreanLastName getRandomKoreanLastName(
            @RequestParam(required = false, defaultValue = "30") int popularity) {
        return koreanNameModel.getRandomKoreanLastName(popularity);
    }

    @GetMapping("/getRandomKoreanFirstName")
    public KoreanFirstName getRandomKoreanFirstName(
            @RequestParam(required = false, defaultValue = "1000") int popularity) {
        return koreanNameModel.getRandomKoreanFirstName(popularity);
    }

    @GetMapping("/getRandomKoreanFullName")
    public String getRandomKoreanFullName(
            @RequestParam(name = "lastNamePopularity", required = false, defaultValue = "30") int lastNamePopularity,
            @RequestParam(name = "firstNamePopularity", required = false, defaultValue = "1000") int firstNamePopularity) {
        return koreanNameModel.getRandomKoreanName(lastNamePopularity, firstNamePopularity);
    }

}
