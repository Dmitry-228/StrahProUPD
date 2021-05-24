package com.example.strahpro.data;

public class RegionTransport {
    private String name;
    private Double rBt;

    public RegionTransport(String name, Double rBt) {
        this.name = name;
        this.rBt = rBt;
    }

    public String getName() {
        return name;
    }

    public Double getrBt() {
        return rBt;
    }
}
