package model;

import model.Moves.Moves;

import java.util.ArrayList;

public class Form {
    private String name;
    private String experienceGroup;
    private Dimensions dimensions;
    private Moves moves;
    private Abilities abilities;
    private Movement movement;
    private Aggression aggression;
    private BattleStats battleStats;
    private ArrayList<String> tags;
    private Spawn spawn;
    private ArrayList<String> possibleGenders = new ArrayList<>();
    private ArrayList<GenderProperty> genderProperties = new ArrayList<>();
    private ArrayList<String> eggGroups = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> preEvolutions = new ArrayList<>();
    private String defaultBaseForm;
    private ArrayList<String> megaItems = new ArrayList<>();
    private ArrayList<String> megas = new ArrayList<>();
    private Gigantamax gigantamax;
    private Integer eggCycles;
    private Double weight;
    private Integer catchRate;
    private Double malePercentage;
    private ArrayList<Evolution> evolutions = new ArrayList<>();
    private EvYields evYields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperienceGroup() {
        return experienceGroup;
    }

    public void setExperienceGroup(String experienceGroup) {
        this.experienceGroup = experienceGroup;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Moves getMoves() {
        return moves;
    }

    public void setMoves(Moves moves) {
        this.moves = moves;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Aggression getAggression() {
        return aggression;
    }

    public void setAggression(Aggression aggression) {
        this.aggression = aggression;
    }

    public BattleStats getBattleStats() {
        return battleStats;
    }

    public void setBattleStats(BattleStats battleStats) {
        this.battleStats = battleStats;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Spawn getSpawn() {
        return spawn;
    }

    public void setSpawn(Spawn spawn) {
        this.spawn = spawn;
    }

    public ArrayList<String> getPossibleGenders() {
        return possibleGenders;
    }

    public void setPossibleGenders(ArrayList<String> possibleGenders) {
        this.possibleGenders = possibleGenders;
    }

    public ArrayList<GenderProperty> getGenderProperties() {
        return genderProperties;
    }

    public void setGenderProperties(ArrayList<GenderProperty> genderProperties) {
        this.genderProperties = genderProperties;
    }

    public ArrayList<String> getEggGroups() {
        return eggGroups;
    }

    public void setEggGroups(ArrayList<String> eggGroups) {
        this.eggGroups = eggGroups;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getPreEvolutions() {
        return preEvolutions;
    }

    public void setPreEvolutions(ArrayList<String> preEvolutions) {
        this.preEvolutions = preEvolutions;
    }

    public String getDefaultBaseForm() {
        return defaultBaseForm;
    }

    public void setDefaultBaseForm(String defaultBaseForm) {
        this.defaultBaseForm = defaultBaseForm;
    }

    public ArrayList<String> getMegaItems() {
        return megaItems;
    }

    public void setMegaItems(ArrayList<String> megaItems) {
        this.megaItems = megaItems;
    }

    public ArrayList<String> getMegas() {
        return megas;
    }

    public void setMegas(ArrayList<String> megas) {
        this.megas = megas;
    }

    public Gigantamax getGigantamax() {
        return gigantamax;
    }

    public void setGigantamax(Gigantamax gigantamax) {
        this.gigantamax = gigantamax;
    }

    public Integer getEggCycles() {
        return eggCycles;
    }

    public void setEggCycles(Integer eggCycles) {
        this.eggCycles = eggCycles;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(Integer catchRate) {
        this.catchRate = catchRate;
    }

    public Double getMalePercentage() {
        return malePercentage;
    }

    public void setMalePercentage(Double malePercentage) {
        this.malePercentage = malePercentage;
    }

    public ArrayList<Evolution> getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(ArrayList<Evolution> evolutions) {
        this.evolutions = evolutions;
    }

    public EvYields getEvYields() {
        return evYields;
    }

    public void setEvYields(EvYields evYields) {
        this.evYields = evYields;
    }

    public ArrayList<String> getParticularObjects(String nameOfObject) {
        return switch (nameOfObject) {
            case "eggGroups" -> this.eggGroups;
            case "types" -> this.types;
            case "preEvolutions" -> this.preEvolutions;
            case "megaItems" -> this.megaItems;
            case "megas" -> this.megas;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "form{" +
                "name='" + name + '\'' +
                ", experienceGroup='" + experienceGroup + '\'' +
                ", dimensions=" + dimensions +
                '}';
    }
}
