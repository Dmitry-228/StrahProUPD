package com.example.strahpro.data;

public class AgeTransport {
    private String name;
    private Double ageBt;

    public AgeTransport(String name, Double ageBt) {
        this.name = name;
        this.ageBt = ageBt;
    }

    public String getName() {
        return name;
    }

    public Double getAgeBt() {
        return ageBt;
    }
}
