package model;

import java.util.ArrayList;

public class PrototypeJSON {
    private String name;
    private Integer dex;
    private ArrayList<String> defaultForms = new ArrayList<>();

    private ArrayList<Form> forms = new ArrayList<>();

    private int generation;

    public ArrayList<Form> getForms() {
        return forms;
    }

    public void setForms(ArrayList<Form> forms) {
        this.forms = forms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public ArrayList<String> getDefaultForms() {
        return defaultForms;
    }

    public void setDefaultForms(ArrayList<String> defaultForms) {
        this.defaultForms = defaultForms;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
