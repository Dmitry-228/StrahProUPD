package com.example.strahpro.data;

public class StageTransport {
    private String name;
    private Double sBt;

    public StageTransport(String name, Double sBt) {
        this.name = name;
        this.sBt = sBt;
    }

    public String getName() {
        return name;
    }

    public Double getsBt() {
        return sBt;
    }
}
