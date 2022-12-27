package com.minholim.KoreanNameGenerator.model;

public class KoreanFullName {

    private final String E_lastName;
    private final String K_lastName;

    // Korean Name
    private final String K_firstName;
    // Romanized English Name
    private final String E_firstName;

    public KoreanFullName(KoreanFirstName koreanFirstName, KoreanLastName koreanLastName) {

        this.E_firstName = koreanFirstName.getE_firstName();
        this.K_firstName = koreanFirstName.getK_firstName();

        this.E_lastName = koreanLastName.getE_LastName();
        this.K_lastName = koreanLastName.getK_LastName();
    }

    public String getE_LastName() {
        return E_lastName;
    }

    public String getK_LastName() {
        return K_lastName;
    }

    public String getK_firstName() {
        return K_firstName;
    }

    public String getE_firstName() {
        return E_firstName;
    }
}
