package EvoConditions;

import java.util.Arrays;
import java.util.List;

public enum EvolutionRockType {
    ICE_ROCK,
    MOSSY_ROCK;

    public static EvolutionRockType getRock(String rock) {
        List<EvolutionRockType> rocks = Arrays.stream(EvolutionRockType.values()).toList().stream()
                .filter(rockEnum -> rockEnum.toString().equals(rock)).toList();

        return (rocks.isEmpty()) ? null : rocks.get(0);
    }

}
