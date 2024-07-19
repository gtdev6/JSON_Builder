package model;

import EvoConditions.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Evolution {
    private Integer level;
    private Item item;
    private String to;
    private ArrayList<Object> conditions = new ArrayList<>();
    private String evoType;

    private ArrayList<String> moves;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ArrayList<Object> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Object> conditions) {
        this.conditions = conditions;
    }

    public String getEvoType() {
        return evoType;
    }

    public void setEvoType(String evoType) {
        this.evoType = evoType;
    }

    public static Evolution copyEvolution(Evolution evolution) {
        Evolution evolution1 = null;

        if (evolution != null) {
            evolution1 = new Evolution();
            evolution1.setLevel(evolution.getLevel());
            evolution1.setItem(evolution.getItem());
            evolution1.setTo(evolution.getTo());
            evolution1.setConditions(evolution.getConditions());
            evolution1.setEvoType(evolution.getEvoType());
        }

        return evolution1;
    }

    @Override
    public String toString() {
        return "evolution{" +
                ((level == null) ? "" : "level=" + level + ", ") +
                ((item == null) ? "" : "item=" + item + ", ") +
                "to='" + to + '\'' + ", " +
                ((conditions.isEmpty()) ? "conditions=" + "[]"
                        : (conditions.size() > 1) ? "conditions= [" + conditions.get(0).toString() + " ,...]"
                                : "conditions= [" + conditions.get(0).toString() + " ]")
                +
                ", evoType='" + evoType + '\'' + ", " +
                ((moves == null) ? "" : "moves=" + Arrays.toString(moves.toArray())) +
                '}';
    }

    public static String getConditionObjectType(Object condition) {
        if (condition instanceof BattleCriticalCondition)
            return "battleCritical";
        if (condition instanceof BiomeCondition)
            return "biome";
        if (condition instanceof BlocksWalkedOutsideBallCondition)
            return "blocksWalkedOutsideBall";
        if (condition instanceof ChanceCondition)
            return "chance";
        if (condition instanceof EvoCondition)
            return "evoConditionType";
        if (condition instanceof EvoRockCondition)
            return "evoRock";
        if (condition instanceof EvoScrollCondition)
            return "evoScroll";
        if (condition instanceof FriendshipCondition)
            return "friendship";
        if (condition instanceof GenderCondition)
            return "gender";
        if (condition instanceof HealthAbsenceCondition)
            return "healthAbsence";
        if (condition instanceof HeldItemCondition)
            return "heldItem";
        if (condition instanceof HighAltitudeCondition)
            return "highAltitude";
        if (condition instanceof LevelCondition)
            return "level";
        if (condition instanceof MoonPhaseCondition)
            return "moonPhase";
        if (condition instanceof MoveCondition)
            return "move";
        if (condition instanceof MoveTypeCondition)
            return "moveType";
        if (condition instanceof MoveUsesCondition)
            return "moveUses";
        if (condition instanceof NatureCondition)
            return "nature";
        if (condition instanceof NuggetCondition)
            return "nugget";
        if (condition instanceof PartyCondition)
            return "party";
        if (condition instanceof PotionEffectCondition)
            return "potionEffect";
        if (condition instanceof RecoilCondition)
            return "recoil";
        if (condition instanceof ShinyCondition)
            return "shiny";
        if (condition instanceof StatRatioCondition)
            return "statRatio";
        if (condition instanceof StatusCondition)
            return "status";
        if (condition instanceof TimeCondition)
            return "time";
        if (condition instanceof WeatherCondition)
            return "weather";
        if (condition instanceof WithinStructureCondition)
            return "withinStructure";
        return null;
    }

    public Class<?> getClassFromString(String conditionType) {
        switch (conditionType) {
            case "critical" -> {
                return BattleCriticalCondition.class;
            }
            case "biome" -> {
                return BiomeCondition.class;
            }
            case "blocksWalkedOutsideBall" -> {
                return BlocksWalkedOutsideBallCondition.class;
            }
            case "chance" -> {
                return ChanceCondition.class;
            }
            case "evoRock" -> {
                return EvoRockCondition.class;
            }
            case "evoScroll" -> {
                return EvoScrollCondition.class;
            }
            case "friendship" -> {
                return FriendshipCondition.class;
            }
            case "gender" -> {
                return GenderCondition.class;
            }
            case "healthAbsence" -> {
                return HealthAbsenceCondition.class;
            }
            case "heldItem" -> {
                return HeldItemCondition.class;
            }
            case "highAltitude" -> {
                return HighAltitudeCondition.class;
            }
            case "level" -> {
                return LevelCondition.class;
            }
            case "moonPhase" -> {
                return MoonPhaseCondition.class;
            }
            case "move" -> {
                return MoveCondition.class;
            }
            case "moveType" -> {
                return MoveTypeCondition.class;
            }
            case "moveUses" -> {
                return MoveUsesCondition.class;
            }
            case "nature" -> {
                return NatureCondition.class;
            }
            case "nugget" -> {
                return NuggetCondition.class;
            }
            case "party" -> {
                return PartyCondition.class;
            }
            case "potionEffect" -> {
                return PotionEffectCondition.class;
            }
            case "recoil" -> {
                return RecoilCondition.class;
            }
            case "shiny" -> {
                return ShinyCondition.class;
            }
            case "statRatio" -> {
                return StatRatioCondition.class;
            }
            case "time" -> {
                return TimeCondition.class;
            }
            case "weather" -> {
                return WeatherCondition.class;
            }
            case "withinStructure" -> {
                return WithinStructureCondition.class;
            }
            default -> {
                return EvoCondition.class;
            }
        }
    }

}
