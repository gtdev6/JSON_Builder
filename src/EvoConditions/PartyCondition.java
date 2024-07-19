package EvoConditions;

import java.util.ArrayList;
import java.util.Arrays;

public class PartyCondition {
    ArrayList<String> withForms;
    ArrayList<String> withPalettes;
    ArrayList<String> withPokemon;
    ArrayList<String> withTypes;
    public final String evoConditionType = "party";

    public PartyCondition(ArrayList<String> withForms, ArrayList<String> withPalettes, ArrayList<String> withPokemon,
            ArrayList<String> withTypes) {
        this.withForms = withForms;
        this.withPalettes = withPalettes;
        this.withPokemon = withPokemon;
        this.withTypes = withTypes;
    }

    public ArrayList<String> getWithForms() {
        return withForms;
    }

    public void setWithForms(ArrayList<String> withForms) {
        this.withForms = withForms;
    }

    public ArrayList<String> getWithPalettes() {
        return withPalettes;
    }

    public void setWithPalettes(ArrayList<String> withPalettes) {
        this.withPalettes = withPalettes;
    }

    public ArrayList<String> getWithPokemon() {
        return withPokemon;
    }

    public void setWithPokemon(ArrayList<String> withPokemon) {
        this.withPokemon = withPokemon;
    }

    public ArrayList<String> getWithTypes() {
        return withTypes;
    }

    public void setWithTypes(ArrayList<String> withTypes) {
        this.withTypes = withTypes;
    }

    @Override
    public String toString() {
        return "{" +
                "withForms=" + Arrays.toString(withForms.toArray()) +
                ((withPalettes != null) ? (", withPalettes=" + Arrays.toString(withPalettes.toArray())) : "") +
                ", withPokemon=" + Arrays.toString(withPokemon.toArray()) +
                ", withTypes=" + Arrays.toString(withTypes.toArray()) +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
