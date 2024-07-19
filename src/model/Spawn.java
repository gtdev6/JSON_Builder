package model;

import java.util.ArrayList;

public class Spawn {
    private Integer baseExp;
    private Integer baseFriendship;
    private Integer spawnLevel;
    private Integer spawnLevelRange;
    private ArrayList<String> spawnLocations = new ArrayList<>();

    public Spawn() {
    }

    public Integer getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(Integer baseExp) {
        this.baseExp = baseExp;
    }

    public Integer getBaseFriendship() {
        return baseFriendship;
    }

    public void setBaseFriendship(Integer baseFriendship) {
        this.baseFriendship = baseFriendship;
    }

    public Integer getSpawnLevel() {
        return spawnLevel;
    }

    public void setSpawnLevel(int spawnLevel) {
        this.spawnLevel = spawnLevel;
    }

    public Integer getSpawnLevelRange() {
        return spawnLevelRange;
    }

    public void setSpawnLevelRange(int spawnLevelRange) {
        this.spawnLevelRange = spawnLevelRange;
    }

    public ArrayList<String> getSpawnLocations() {
        return spawnLocations;
    }

    public void setSpawnLocations(ArrayList<String> spawnLocations) {
        this.spawnLocations = spawnLocations;
    }

    public void addAll(int _baseExp, int _baseFriendship, int _spawnLevel, int _spawnLevelRange) {
        setBaseExp(_baseExp);
        setBaseFriendship(_baseFriendship);
        setSpawnLevel(_spawnLevel);
        setSpawnLevelRange(_spawnLevelRange);
    }
}