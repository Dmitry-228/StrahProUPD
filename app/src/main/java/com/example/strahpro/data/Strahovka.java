package com.example.strahpro.data;

public class Strahovka {
    protected Double price;
    protected String date;
    protected int stage = 0;
    protected int id;

    public Strahovka(String date, double price, int stage) {
        this.price = price;
        this.date = date;
        this.stage = stage;
    }

    public Strahovka(String date, double price) {
        this.price = price;
        this.date = date;
    }
    public Strahovka(int id, String date, double price) {
        this.price = price;
        this.date = date;
        this.id = id;
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
