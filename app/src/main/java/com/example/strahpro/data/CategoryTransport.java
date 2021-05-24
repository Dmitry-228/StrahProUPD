package com.example.strahpro.data;

public class CategoryTransport {
    private String name;
    private Double cBt;

    public CategoryTransport(String name, Double cBt) {
        this.name = name;
        this.cBt = cBt;
    }

    public String getName() {
        return name;
    }

    public Double getcBt() {
        return cBt;
    }
}
