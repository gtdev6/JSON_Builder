package model.Moves;

import java.util.ArrayList;

public class Moves {
    private ArrayList<LevelUpMove> levelUpMoves = new ArrayList<>();
    private ArrayList<String> tutorMoves = new ArrayList<>();
    private ArrayList<String> eggMoves = new ArrayList<>();
    private ArrayList<String> tmMoves8 = new ArrayList<>();
    private ArrayList<String> trMoves = new ArrayList<>();
    private ArrayList<String> hmMoves = new ArrayList<>();
    private ArrayList<String> transferMoves = new ArrayList<>();
    private ArrayList<String> tmMoves7 = new ArrayList<>();
    private ArrayList<String> tmMoves6 = new ArrayList<>();
    private ArrayList<String> tmMoves5 = new ArrayList<>();
    private ArrayList<String> tmMoves4 = new ArrayList<>();
    private ArrayList<String> tmMoves3 = new ArrayList<>();
    private ArrayList<String> tmMoves2 = new ArrayList<>();
    private ArrayList<String> tmMoves1 = new ArrayList<>();
    private ArrayList<String> tmMoves = new ArrayList<>();

    public ArrayList<LevelUpMove> getLevelUpMoves() {
        return levelUpMoves;
    }

    public void setLevelUpMoves(ArrayList<LevelUpMove> levelUpMoves) {
        this.levelUpMoves = levelUpMoves;
    }

    public ArrayList<String> getTutorMoves() {
        return tutorMoves;
    }

    public void setTutorMoves(ArrayList<String> tutorMoves) {
        this.tutorMoves = tutorMoves;
    }

    public ArrayList<String> getEggMoves() {
        return eggMoves;
    }

    public void setEggMoves(ArrayList<String> eggMoves) {
        this.eggMoves = eggMoves;
    }

    public ArrayList<String> getTmMoves8() {
        return tmMoves8;
    }

    public void setTmMoves8(ArrayList<String> tmMoves8) {
        this.tmMoves8 = tmMoves8;
    }

    public ArrayList<String> getTrMoves() {
        return trMoves;
    }

    public void setTrMoves(ArrayList<String> trMoves) {
        this.trMoves = trMoves;
    }

    public ArrayList<String> getHmMoves() {
        return hmMoves;
    }

    public void setHmMoves(ArrayList<String> hmMoves) {
        this.hmMoves = hmMoves;
    }

    public ArrayList<String> getTransferMoves() {
        return transferMoves;
    }

    public void setTransferMoves(ArrayList<String> transferMoves) {
        this.transferMoves = transferMoves;
    }

    public ArrayList<String> getTmMoves7() {
        return tmMoves7;
    }

    public void setTmMoves7(ArrayList<String> tmMoves7) {
        this.tmMoves7 = tmMoves7;
    }

    public ArrayList<String> getTmMoves6() {
        return tmMoves6;
    }

    public void setTmMoves6(ArrayList<String> tmMoves6) {
        this.tmMoves6 = tmMoves6;
    }

    public ArrayList<String> getTmMoves5() {
        return tmMoves5;
    }

    public void setTmMoves5(ArrayList<String> tmMoves5) {
        this.tmMoves5 = tmMoves5;
    }

    public ArrayList<String> getTmMoves4() {
        return tmMoves4;
    }

    public void setTmMoves4(ArrayList<String> tmMoves4) {
        this.tmMoves4 = tmMoves4;
    }

    public ArrayList<String> getTmMoves3() {
        return tmMoves3;
    }

    public void setTmMoves3(ArrayList<String> tmMoves3) {
        this.tmMoves3 = tmMoves3;
    }

    public ArrayList<String> getTmMoves2() {
        return tmMoves2;
    }

    public void setTmMoves2(ArrayList<String> tmMoves2) {
        this.tmMoves2 = tmMoves2;
    }

    public ArrayList<String> getTmMoves1() {
        return tmMoves1;
    }

    public void setTmMoves1(ArrayList<String> tmMoves1) {
        this.tmMoves1 = tmMoves1;
    }

    public ArrayList<String> getTmMoves() {
        return tmMoves;
    }

    public void setTmMoves(ArrayList<String> tmMoves) {
        this.tmMoves = tmMoves;
    }

    public ArrayList<String> getMoves(String nameOfMoves) {
        return switch (nameOfMoves) {
            case "tutorMoves" -> this.tutorMoves;
            case "eggMoves" -> this.eggMoves;
            case "tmMoves8" -> this.tmMoves8;
            case "trMoves" -> this.trMoves;
            case "hmMoves" -> this.hmMoves;
            case "transferMoves" -> this.transferMoves;
            case "tmMoves7" -> this.tmMoves7;
            case "tmMoves6" -> this.tmMoves6;
            case "tmMoves5" -> this.tmMoves5;
            case "tmMoves4" -> this.tmMoves4;
            case "tmMoves3" -> this.tmMoves3;
            case "tmMoves2" -> this.tmMoves2;
            case "tmMoves1" -> this.tmMoves1;
            case "tmMoves" -> this.tmMoves;
            default -> null;
        };
    }

}