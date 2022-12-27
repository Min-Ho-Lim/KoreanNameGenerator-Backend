package com.minholim.KoreanNameGenerator.model;

public class KoreanFirstName {

    // Korean Name
    private final String K_firstName;
    // Romanized English Name
    private final String E_firstName;
    // Ratio between masculine and feminine
    // Close to -1.0 means more feminine and close to 1.0 means more masculine
    private final double ratioMasculineFeminine;

    // Constructor
    public KoreanFirstName(String K_firstName, String E_firstName, double ratioMasculineFeminine) {
        this.K_firstName = K_firstName;
        this.E_firstName = E_firstName;
        this.ratioMasculineFeminine = ratioMasculineFeminine;
    }

    // Getter
    public String getK_firstName() {
        return K_firstName;
    }

    public String getE_firstName() {
        return E_firstName;
    }

    public double getRatioMasculineFeminine() {
        return ratioMasculineFeminine;
    }
}
