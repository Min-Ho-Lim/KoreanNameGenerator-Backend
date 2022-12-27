package com.minholim.KoreanNameGenerator.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minholim.KoreanNameGenerator.model.KoreanLastName;
import com.minholim.KoreanNameGenerator.model.KoreanNameModel;

@RestController
public class KoreanNameController {

    private KoreanNameModel koreanNameModel = new KoreanNameModel();

    @GetMapping("/getRandomKoreanName")
    public KoreanLastName getRandomKoreanName() {
        return koreanNameModel.getRandomKoreanLastName();
    }

}
