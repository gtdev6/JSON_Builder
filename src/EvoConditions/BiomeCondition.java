package EvoConditions;

import java.util.ArrayList;

public class BiomeCondition {
    private ArrayList<String> biomes;
    public final String evoConditionType = "biome";

    public BiomeCondition() {
    }

    public ArrayList<String> getBiomes() {
        return biomes;
    }

    public void setBiomes(ArrayList<String> biomes) {
        this.biomes = biomes;
    }

    public String getEvoConditionType() {
        return evoConditionType;
    }

    @Override
    public String toString() {
        String str1 = "{ \"biomes\"=";
        if (biomes.size() >= 1) {
            str1 = str1.concat(biomes.get(0) + ", ..." + " , \"evoConditionType\"='" + evoConditionType + "'}");
            return str1;
        }
        return "{" + "evoConditionType=" + evoConditionType +
                '}';
    }
}
