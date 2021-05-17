package com.example.strahpro.data;

class StrahovkaOsago extends Strahovka {
    private double power;
    private String categorie;
    private String region;

    public StrahovkaOsago(double price, String date, int stage) {
        super(price, date, stage);
    }

    public StrahovkaOsago(double price, String date, int stage, double power, String categorie, String region) {
        super(price, date, stage);
        this.power = power;
        this.categorie = categorie;
        this.region = region;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
