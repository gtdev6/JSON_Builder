package model;

import java.util.ArrayList;
import java.util.List;

public class modelLocator {
    private String factoryType;
    private ArrayList<String> pqc = new ArrayList<>();
    private Double yRotation;

    public String getFactoryType() {
        return factoryType;
    }

    public void setFactoryType(String factoryType) {
        this.factoryType = factoryType;
    }

    public ArrayList<String> getPqc() {
        return pqc;
    }

    public void setPqc(ArrayList<String> pgc) {
        this.pqc = pgc;
    }

    public Double getyRotation() {
        return yRotation;
    }

    public void setyRotation(Double yRotation) {
        this.yRotation = yRotation;
    }

    public String pqcToString() {
        StringBuilder sd = new StringBuilder();
        for (String el : this.pqc) {
            sd.append("pqc: " + el + "\n");
        }
        return sd.toString();
    }

    @Override
    public String toString() {
        return "factoryType: " + this.factoryType + "\n" +
                pqcToString() +
                "yRotation: " + this.yRotation;
    }
}