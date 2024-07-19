package model.Moves;

import java.util.ArrayList;

public class LevelUpMove {
    private int level;
    private ArrayList<String> attacks = new ArrayList<>();

    public LevelUpMove() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<String> getAttacks() {
        return attacks;
    }

    public void setAttacks(ArrayList<String> attacks) {
        this.attacks = attacks;
    }

    public String getAttacksArrayToString() {
        if (attacks.isEmpty())
            return "[]";
        StringBuilder bd = new StringBuilder("[");
        attacks.forEach(e -> bd.append(" " + e + ","));
        bd.replace(bd.length() - 1, bd.length(), "");
        bd.append(" ]");
        return bd.toString();
    }

    @Override
    public String toString() {
        return "level= " + level +
                ", attacks=" + getAttacksArrayToString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LevelUpMove))
            return false;
        LevelUpMove alt = (LevelUpMove) obj;
        return this.level == alt.level && this.attacks.equals(alt.attacks);
    }
}