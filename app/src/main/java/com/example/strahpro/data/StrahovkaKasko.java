package com.example.strahpro.data;

class StrahovkaKasko extends Strahovka {
    private int age;
    private double carPrice;
    private boolean alarm;

    public StrahovkaKasko(double price, String date, int stage) {
        super(price, date, stage);
    }

    public StrahovkaKasko(double price, String date, int stage, int age, String price1, boolean alarm) {
        super(price, date, stage);
        this.age = age;
        this.price = carPrice;
        this.alarm = alarm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setPrice(double price) {
        this.carPrice = carPrice;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}
