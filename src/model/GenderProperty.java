package model;

import java.util.ArrayList;

public class GenderProperty {
    private String gender;
    private ArrayList<Palette> palettes = new ArrayList<>();

    public String getGender() {
        return gender;
    }

    public void setGender(String name) {
        this.gender = name;
    }

    public ArrayList<Palette> getPalettes() {
        return palettes;
    }

    public void setPalettes(ArrayList<Palette> palettes) {
        this.palettes = palettes;
    }

    @Override
    public String toString() {
        return "genderProperty {" +
                "gender ='" + gender + '\'' +
                ", palettes=" + palettes.toString() +
                '}';
    }
}