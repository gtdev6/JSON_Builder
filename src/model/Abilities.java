package model;

import java.util.ArrayList;

public class Abilities {
    private ArrayList<String> abilities = new ArrayList<>();
    private ArrayList<String> hiddenAbilities = new ArrayList<>();

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<String> getHiddenAbilities() {
        return hiddenAbilities;
    }

    public void setHiddenAbilities(ArrayList<String> hiddenAbilities) {
        this.hiddenAbilities = hiddenAbilities;
    }

    public Abilities() {
    }
}