package com.minholim.KoreanNameGenerator.model;

public class KoreanLastName {

    private final String E_lastName;
    private final String K_lastName;

    public KoreanLastName(String K_lastName, String E_lastName) {
        this.E_lastName = E_lastName;
        this.K_lastName = K_lastName;
    }

    public String getE_LastName() {
        return E_lastName;
    }

    public String getK_LastName() {
        return K_lastName;
    }

}
