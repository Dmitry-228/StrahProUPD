package com.example.strahpro.data;

class Strahovka {
    protected double price;
    protected String date;
    protected int stage;

    public Strahovka(double price, String date, int stage) {
        this.price = price;
        this.date = date;
        this.stage = stage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
