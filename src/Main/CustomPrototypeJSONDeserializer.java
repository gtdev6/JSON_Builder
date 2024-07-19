package Main;

import EvoConditions.*;
import model.*;
import model.ModelLocator.ModelLocator;
import model.Moves.LevelUpMove;
import model.Moves.Moves;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;

public class CustomPrototypeJSONDeserializer extends JsonDeserializer<PrototypeJSON> {
    @Override
    public PrototypeJSON deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        PrototypeJSON prototypeJSON_obj = new PrototypeJSON();

        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            if ("name".equals(fieldName)) {
                prototypeJSON_obj.setName(jsonParser.getValueAsString());
            } else if ("dex".equals(fieldName)) {
                prototypeJSON_obj.setDex(jsonParser.getValueAsInt());
            } else if ("defaultForms".equals(fieldName)) {
                ArrayList<String> defaultForms = deserializeDefaultForms(jsonParser);
                prototypeJSON_obj.setDefaultForms(defaultForms);
            } else if ("forms".equals(fieldName)) {
                ArrayList<Form> forms = deserializeForms(jsonParser, deserializationContext);
                prototypeJSON_obj.setForms(forms);
            } else if ("generation".equals(fieldName)) {
                prototypeJSON_obj.setGeneration(jsonParser.getValueAsInt());
            }
        }
        return prototypeJSON_obj;
    }

    private ArrayList<String> deserializeDefaultForms(JsonParser jsonParser) throws IOException {
        ArrayList<String> defaultForms = new ArrayList<>();

        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                String forms = jsonParser.getValueAsString();
                defaultForms.add(forms);
            }
        }

        return defaultForms;
    }

    private ArrayList<Form> deserializeForms(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        ArrayList<Form> forms = new ArrayList<>();
        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                // Handling Individual Form Object
                if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                    Form form_indiviual = new Form();
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = jsonParser.getCurrentName();
                        jsonParser.nextToken();
                        if ("name".equals(fieldName))
                            form_indiviual.setName(jsonParser.getValueAsString());
                        else if ("experienceGroup".equals(fieldName)) {
                            form_indiviual.setExperienceGroup(jsonParser.getValueAsString());
                        } else if ("dimensions".equals(fieldName)) {
                            Dimensions dimensions = deserializeDimension(jsonParser);
                            form_indiviual.setDimensions(dimensions);
                        } else if ("moves".equals(fieldName)) {
                            Moves moves = deserializeMoves(jsonParser);
                            form_indiviual.setMoves(moves);
                        } else if ("abilities".equals(fieldName)) {
                            Abilities abilities = deserializeAbilities(jsonParser);
                            form_indiviual.setAbilities(abilities);
                        } else if ("movement".equals(fieldName)) {
                            Movement movement = deserializeMovement(jsonParser);
                            form_indiviual.setMovement(movement);
                        } else if ("aggression".equals(fieldName)) {
                            Aggression aggression = deserializeAggression(jsonParser);
                            form_indiviual.setAggression(aggression);
                        } else if ("battleStats".equals(fieldName)) {
                            BattleStats battleStats = deserializeBattleStats(jsonParser);
                            form_indiviual.setBattleStats(battleStats);
                        } else if ("tags".equals(fieldName)) {
                            ArrayList<String> tags = deserializeStringArray(jsonParser);
                            form_indiviual.setTags(tags);
                        } else if ("spawn".equals(fieldName)) {
                            Spawn spawn = deserializeSpawn(jsonParser);
                            form_indiviual.setSpawn(spawn);
                        } else if ("possibleGenders".equals(fieldName)) {
                            ArrayList<String> possibleGenders = deserializeStringArray(jsonParser);
                            form_indiviual.setPossibleGenders(possibleGenders);
                        } else if ("genderProperties".equals(fieldName)) {
                            ArrayList<GenderProperty> genderProperties = deserializeGenderProperties(jsonParser);
                            form_indiviual.setGenderProperties(genderProperties);
                        } else if ("eggGroups".equals(fieldName)) {
                            ArrayList<String> eggGroups = deserializeStringArray(jsonParser);
                            form_indiviual.setEggGroups(eggGroups);
                        } else if ("types".equals(fieldName)) {
                            ArrayList<String> types = deserializeStringArray(jsonParser);
                            form_indiviual.setTypes(types);
                        } else if ("preEvolutions".equals(fieldName)) {
                            ArrayList<String> preEvolutions = deserializeStringArray(jsonParser);
                            form_indiviual.setPreEvolutions(preEvolutions);
                        } else if ("defaultBaseForm".equals(fieldName)) {
                            form_indiviual.setDefaultBaseForm(jsonParser.getValueAsString());
                        } else if ("megaItems".equals(fieldName)) {
                            ArrayList<String> megaItems = deserializeStringArray(jsonParser);
                            form_indiviual.setMegaItems(megaItems);
                        } else if ("megas".equals(fieldName)) {
                            ArrayList<String> megas = deserializeStringArray(jsonParser);
                            form_indiviual.setMegas(megas);
                        } else if ("gigantamax".equals(fieldName)) {
                            Gigantamax gigantamax = deserializeGigantamax(jsonParser);
                            form_indiviual.setGigantamax(gigantamax);
                        } else if ("eggCycles".equals(fieldName)) {
                            form_indiviual.setEggCycles(jsonParser.getValueAsInt());
                        } else if ("weight".equals(fieldName)) {
                            form_indiviual.setWeight(jsonParser.getValueAsDouble());
                        } else if ("catchRate".equals(fieldName)) {
                            form_indiviual.setCatchRate(jsonParser.getValueAsInt());
                        } else if ("malePercentage".equals(fieldName)) {
                            form_indiviual.setMalePercentage(jsonParser.getValueAsDouble());
                        } else if ("evolutions".equals(fieldName)) {
                            ArrayList<Evolution> evolutions = deserializeEvolutionsArray(jsonParser,
                                    deserializationContext);
                            // ArrayList<Evolution> evolutions =
                            form_indiviual.setEvolutions(evolutions);
                        } else if ("evYields".equals(fieldName)) {
                            EvYields evYields = deserializeEvYields(jsonParser);
                            form_indiviual.setEvYields(evYields);
                        }

                    }
                    forms.add(form_indiviual);
                }
            }
            return forms;
        }
        return null;
    }

    private EvYields deserializeEvYields(JsonParser jsonParser) throws IOException {
        EvYields evYields = new EvYields();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "hp" -> evYields.setHp(jsonParser.getValueAsInt());
                    case "attack" -> evYields.setAttack(jsonParser.getValueAsInt());
                    case "defense" -> evYields.setDefense(jsonParser.getValueAsInt());
                    case "specialAttack" -> evYields.setSpecialAttack(jsonParser.getValueAsInt());
                    case "specialDefense" -> evYields.setSpecialDefense(jsonParser.getValueAsInt());
                    case "speed" -> evYields.setSpeed(jsonParser.getValueAsInt());
                }
            }
            return evYields;
        }
        return null;
    }

    private ArrayList<Evolution> deserializeEvolutionsArray(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException {
        ArrayList<Evolution> evolutions = new ArrayList<>();
        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                Evolution evolution = deserializationContext.readValue(jsonParser, Evolution.class);
                evolutions.add(evolution);

                // Handling Individual GenderProperty Object
                // if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                // Evolution evolution = new Evolution();
                // while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                // String fieldName = jsonParser.getCurrentName();
                // jsonParser.nextToken();
                // if(fieldName.equals("level")){
                // evolution.setLevel(jsonParser.getValueAsInt());
                // } else if (fieldName.equals("item")) {
                // Item item = deserializeItemObject(jsonParser);
                // evolution.setItem(item);
                // } else if (fieldName.equals("to")) {
                // evolution.setTo(jsonParser.getValueAsString());
                // } else if (fieldName.equals("conditions")) {
                // ArrayList<Object> conditions = deserializeConditions(jsonParser);
                // evolution.setConditions(conditions);
                // } else if (fieldName.equals("evoType")) {
                // evolution.setEvoType(jsonParser.getValueAsString());
                // } else if (fieldName.equals("moves")) {
                // evolution.setMoves(deserializeStringArray(jsonParser));
                // }
                //
                // }
                // }
                //
            }
            return evolutions;
        }
        return null;
    }

    private ArrayList<Object> deserializeConditions(JsonParser jsonParser) throws IOException {
        ArrayList<Object> conditions = new ArrayList<>();
        BiomeCondition biomeCondition = null;
        BlocksWalkedOutsideBallCondition blocksWalkedOutsideBallCondition = null;
        ChanceCondition chanceCondition = null;
        BattleCriticalCondition criticalCondition = null;
        EvoCondition evoCondition = null;
        EvoRockCondition evoRockCondition = null;
        EvoScrollCondition evoScrollCondition = null;
        FriendshipCondition friendshipCondition = null;
        GenderCondition genderCondition = null;
        HealthAbsenceCondition healthAbsenceCondition = null;
        HeldItemCondition heldItemCondition = null;
        HighAltitudeCondition highAltitudeCondition = null;
        LevelCondition levelCondition = null;
        MoonPhaseCondition moonPhaseCondition = null;
        MoveCondition moveCondition = null;
        MoveTypeCondition moveTypeCondition = null;
        MoveUsesCondition moveUsesCondition = null;
        NatureCondition natureCondition = null;
        NuggetCondition nuggetCondition = null;
        PartyCondition partyCondition = null;
        PotionEffectCondition potionEffectCondition = null;
        RecoilCondition recoilCondition = null;
        ShinyCondition shinyCondition = null;
        StatRatioCondition statRatioCondition = null;
        StatusCondition statusCondition = null;
        TimeCondition timeCondition = null;
        WeatherCondition weatherCondition = null;
        WithinStructureCondition withinStructureCondition = null;

        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                // Handling Individual GenderProperty Object
                if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                    Object condition_obj = new Object();
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = jsonParser.getCurrentName();
                        jsonParser.nextToken();
                        switch (fieldName) {
                            case ("biomes") -> {
                                biomeCondition = new BiomeCondition();
                                ArrayList<String> biomes = deserializeStringArray(jsonParser);
                                biomeCondition.setBiomes(biomes);
                            }
                            case ("blocksToWalk") -> {
                                blocksWalkedOutsideBallCondition = new BlocksWalkedOutsideBallCondition();
                                blocksWalkedOutsideBallCondition.setBlocksToWalk(jsonParser.getValueAsInt());
                            }
                            case ("chance") -> {
                                chanceCondition = new ChanceCondition();
                                chanceCondition.setChance(jsonParser.getValueAsDouble());
                            }
                            case ("critical") -> {
                                criticalCondition = new BattleCriticalCondition();
                                criticalCondition.setCritical(jsonParser.getValueAsInt());
                            }
                            case ("evolutionRock") -> {
                                evoRockCondition = new EvoRockCondition();
                                evoRockCondition
                                        .setEvolutionRock(EvolutionRockType.getRock(jsonParser.getValueAsString()));
                            }
                            case ("evolutionScroll") -> {
                                // evoRockCondition = new EvoRockCondition();
                                // evoRockCondition.setEvolutionRock(EvolutionRockType.getRock(jsonParser.getValueAsString()));
                            }
                            case ("maxRangeSquared") -> {
                                if (evoRockCondition != null)
                                    evoRockCondition.setMaxRangeSquared(jsonParser.getValueAsInt());
                            }
                            case ("item") -> {
                                heldItemCondition = new HeldItemCondition();
                                Item item = deserializeItemObject(jsonParser);
                                heldItemCondition.setItem(item);
                            }

                            case ("evoConditionType") -> {
                                if (biomeCondition != null) {
                                    condition_obj = biomeCondition;
                                } else if (blocksWalkedOutsideBallCondition != null) {
                                    condition_obj = blocksWalkedOutsideBallCondition;
                                } else if (chanceCondition != null) {
                                    condition_obj = chanceCondition;
                                } else if (criticalCondition != null) {
                                    condition_obj = criticalCondition;
                                } else if (evoRockCondition != null) {
                                    condition_obj = criticalCondition;
                                } else if (evoScrollCondition != null) {
                                    condition_obj = criticalCondition;
                                } else if (friendshipCondition != null) {
                                    condition_obj = criticalCondition;
                                } else if (genderCondition != null) {
                                    condition_obj = criticalCondition;
                                } else if (healthAbsenceCondition != null) {
                                    condition_obj = criticalCondition;
                                } else if (heldItemCondition != null) {
                                    condition_obj = heldItemCondition;
                                }

                            }

                        }
                    }
                    conditions.add(condition_obj);
                    biomeCondition = null;
                    blocksWalkedOutsideBallCondition = null;
                    chanceCondition = null;
                    criticalCondition = null;
                    evoCondition = null;
                    evoRockCondition = null;
                    evoScrollCondition = null;
                    friendshipCondition = null;
                    genderCondition = null;
                    healthAbsenceCondition = null;
                    heldItemCondition = null;
                    highAltitudeCondition = null;
                    levelCondition = null;
                    moonPhaseCondition = null;
                    moveCondition = null;
                    moveTypeCondition = null;
                    moveUsesCondition = null;
                    natureCondition = null;
                    nuggetCondition = null;
                    partyCondition = null;
                    potionEffectCondition = null;
                    recoilCondition = null;
                    shinyCondition = null;
                    statRatioCondition = null;
                    statusCondition = null;
                    timeCondition = null;
                    weatherCondition = null;
                    withinStructureCondition = null;
                }
            }
            return conditions;
        }
        return null;
    }

    private Item deserializeItemObject(JsonParser jsonParser) throws IOException {
        Item item = new Item();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                if (fieldName.equals("itemID")) {
                    item.setItemID(jsonParser.getValueAsString());
                }
            }
            return item;
        }
        return null;
    }

    private Gigantamax deserializeGigantamax(JsonParser jsonParser) throws IOException {
        Gigantamax gigantamax = new Gigantamax();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "canHaveFactor" -> gigantamax.setCanHaveFactor(jsonParser.getValueAsBoolean());
                    case "canGigantamax" -> gigantamax.setCanGigantamax(jsonParser.getValueAsBoolean());
                    case "form" -> gigantamax.setForm(jsonParser.getValueAsString());
                    case "move" -> gigantamax.setMove(jsonParser.getValueAsString());
                }
            }
            return gigantamax;
        }
        return null;
    }

    private ArrayList<GenderProperty> deserializeGenderProperties(JsonParser jsonParser) throws IOException {
        ArrayList<GenderProperty> genderProperties = new ArrayList<>();
        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                // Handling Individual GenderProperty Object
                if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                    GenderProperty genderProperty = new GenderProperty();
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = jsonParser.getCurrentName();
                        jsonParser.nextToken();
                        if (fieldName.equals("gender")) {
                            genderProperty.setGender(jsonParser.getValueAsString());
                        } else if (fieldName.equals("palettes")) {
                            ArrayList<Palette> palettes = deserializePalettesArray(jsonParser);
                            genderProperty.setPalettes(palettes);
                        }

                    }
                    genderProperties.add(genderProperty);
                }
            }
            return genderProperties;
        }
        return null;
    }

    private ArrayList<Palette> deserializePalettesArray(JsonParser jsonParser) throws IOException {
        ArrayList<Palette> palettes_array = new ArrayList<>();
        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                // Handling Individual palette Object
                if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                    Palette palette = new Palette();
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = jsonParser.getCurrentName();
                        jsonParser.nextToken();
                        switch (fieldName) {
                            case "name" -> palette.setName(jsonParser.getValueAsString());
                            case "texture" -> palette.setTexture(jsonParser.getValueAsString());
                            case "sprite" -> palette.setSprite(jsonParser.getValueAsString());
                            case "particle" -> palette.setParticle(jsonParser.getValueAsString());
                            case "emissive" -> palette.setEmissive(jsonParser.getValueAsString());
                            case "normalMap" -> palette.setNormalMap(jsonParser.getValueAsString());
                            case "translationKey" -> palette.setTranslationKey(jsonParser.getValueAsString());
                            case "modelLocator" -> {
                                ModelLocator modelLocator = deserializeModelLocator(jsonParser);
                                palette.setModelLocator(modelLocator);
                            }
                            case "flyingModelLocator" -> {
                                ModelLocator flyingModelLocator = deserializeModelLocator(jsonParser);
                                palette.setFlyingModelLocator(flyingModelLocator);
                            }
                            case "sounds" -> palette.setSounds(deserializeStringArray(jsonParser));
                        }
                    }
                    palettes_array.add(palette);
                }
            }
            return palettes_array;
        }
        return null;
    }

    private ModelLocator deserializeModelLocator(JsonParser jsonParser) throws IOException {
        ModelLocator modelLocator = new ModelLocator();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "factoryType" -> modelLocator.setFactoryType(jsonParser.getValueAsString());
                    case "pqc" -> modelLocator.setPqc(deserializeStringArray(jsonParser));
                    case "animationIncrement" -> modelLocator.setAnimationIncrement(jsonParser.getValueAsDouble());
                    case "movementThreshold" -> modelLocator.setMovementThreshold(jsonParser.getValueAsDouble());
                    case "rotateAngleX" -> modelLocator.setRotateAngleX(jsonParser.getValueAsDouble());
                    case "rotateAngleY" -> modelLocator.setRotateAngleY(jsonParser.getValueAsDouble());
                    case "transparency" -> modelLocator.setTransparency(jsonParser.getValueAsDouble());
                    case "transparency2" -> modelLocator.setTransparency2(jsonParser.getValueAsDouble());
                    case "xOffset" -> modelLocator.setxOffset(jsonParser.getValueAsDouble());
                    case "xRotation" -> modelLocator.setxRotation(jsonParser.getValueAsDouble());
                    case "yOffset" -> modelLocator.setyOffset(jsonParser.getValueAsDouble());
                    case "yRotation" -> modelLocator.setyRotation(jsonParser.getValueAsDouble());
                    case "zOffset" -> modelLocator.setzOffset(jsonParser.getValueAsDouble());
                    case "zRotation" -> modelLocator.setzRotation(jsonParser.getValueAsDouble());
                }
            }
            return modelLocator;
        }
        return null;
    }

    private Spawn deserializeSpawn(JsonParser jsonParser) throws IOException {
        Spawn spawn = new Spawn();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "baseExp" -> spawn.setBaseExp(jsonParser.getValueAsInt());
                    case "baseFriendship" -> spawn.setBaseFriendship(jsonParser.getValueAsInt());
                    case "spawnLevel" -> spawn.setSpawnLevel(jsonParser.getValueAsInt());
                    case "spawnLevelRange" -> spawn.setSpawnLevelRange(jsonParser.getValueAsInt());
                    case "spawnLocations" -> spawn.setSpawnLocations(deserializeStringArray(jsonParser));
                }
            }
            return spawn;
        }
        return null;
    }

    private BattleStats deserializeBattleStats(JsonParser jsonParser) throws IOException {
        BattleStats battleStats = new BattleStats();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "hp" -> battleStats.setHp(jsonParser.getValueAsInt());
                    case "attack" -> battleStats.setAttack(jsonParser.getValueAsInt());
                    case "defense" -> battleStats.setDefense(jsonParser.getValueAsInt());
                    case "specialAttack" -> battleStats.setSpecialAttack(jsonParser.getValueAsInt());
                    case "specialDefense" -> battleStats.setSpecialDefense(jsonParser.getValueAsInt());
                    case "speed" -> battleStats.setSpeed(jsonParser.getValueAsInt());
                }
            }
            return battleStats;
        }
        return null;
    }

    private Aggression deserializeAggression(JsonParser jsonParser) throws IOException {
        Aggression aggression = new Aggression();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "timid" -> aggression.setTimid(jsonParser.getValueAsInt());
                    case "passive" -> aggression.setPassive(jsonParser.getValueAsInt());
                    case "aggressive" -> aggression.setAggressive(jsonParser.getValueAsInt());
                }
            }
            return aggression;
        }
        return null;
    }

    private Movement deserializeMovement(JsonParser jsonParser) throws IOException {
        Movement movement = new Movement();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "rideable" -> movement.setRideable(jsonParser.getValueAsBoolean());
                    case "canFly" -> movement.setCanFly(jsonParser.getValueAsBoolean());
                    case "canSurf" -> movement.setCanSurf(jsonParser.getValueAsBoolean());
                    case "canRideShoulder" -> movement.setCanRideShoulder(jsonParser.getValueAsBoolean());
                    case "ridingOffsets" -> {
                        RidingOffSets ridingOffsets = deserializeRidingOffSets(jsonParser);
                        movement.setRidingOffSets(ridingOffsets);
                    }
                    case "flyingParameters" -> {
                        FlyingParameters flyingParameters = deserializeFlyingParameters(jsonParser);
                        movement.setFlyingParameters(flyingParameters);
                    }
                    case "mountedFlyingParameters" -> {
                        MountedFlyingParameters mountedFlyingParameters = deserializeMountedFlyingParameters(
                                jsonParser);
                        movement.setMountedFlyingParameters(mountedFlyingParameters);
                    }
                    case "swimmingParameters" -> {
                        SwimmingParameters swimmingParameters = deserializeSwimmingParameters(jsonParser);
                        movement.setSwimmingParameters(swimmingParameters);
                    }
                }
            }
            return movement;
        }
        return null;
    }

    private SwimmingParameters deserializeSwimmingParameters(JsonParser jsonParser) throws IOException {
        SwimmingParameters swimmingParameters = new SwimmingParameters();
        BlockParameter blockParameter = new BlockParameter();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "depthRangeStart" -> swimmingParameters.setDepthRangeStart(jsonParser.getValueAsInt());
                    case "depthRangeEnd" -> swimmingParameters.setDepthRangeEnd(jsonParser.getValueAsInt());
                    case "swimSpeed" -> swimmingParameters.setSwimSpeed(jsonParser.getValueAsDouble());
                    case "decayRate" -> swimmingParameters.setDecayRate(jsonParser.getValueAsDouble());
                    case "refreshRate" -> swimmingParameters.setRefreshRate(jsonParser.getValueAsInt());
                    case "chanceToStopOnBlock" -> {
                        swimmingParameters.setHasBlockParameter(true);
                        blockParameter.setChanceToStopOnBlock(jsonParser.getValueAsDouble());
                    }
                    case "blocksToStopOn" -> blockParameter.setBlocksToStopOn(deserializeStringArray(jsonParser));
                    case "minStopTime" -> blockParameter.setMinStopTime(jsonParser.getValueAsInt());
                    case "maxStopTime" -> blockParameter.setMaxStopTime(jsonParser.getValueAsInt());
                    case "minStopCooldownTime" -> blockParameter.setMinStopCooldownTime(jsonParser.getValueAsInt());
                    case "maxStopCooldownTime" -> blockParameter.setMaxStopCooldownTime(jsonParser.getValueAsInt());
                    case "canRotateWhileStopped" -> {
                        swimmingParameters.setCanRotateParameter(true);
                        blockParameter.setCanRotateWhileStopped(jsonParser.getValueAsBoolean());
                    }

                }
            }
            if (swimmingParameters.isHasBlockParameter())
                swimmingParameters.setBlockParameter(blockParameter);
            return swimmingParameters;
        }
        return null;

    }

    private MountedFlyingParameters deserializeMountedFlyingParameters(JsonParser jsonParser) throws IOException {
        MountedFlyingParameters mountedFlyingParameters = new MountedFlyingParameters();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "type" -> mountedFlyingParameters.setType(jsonParser.getValueAsString());
                    case "upper_angle_limit" ->
                        mountedFlyingParameters.setUpper_angle_limit(jsonParser.getValueAsInt());
                    case "lower_angle_limit" ->
                        mountedFlyingParameters.setLower_angle_limit(jsonParser.getValueAsInt());
                    case "max_fly_speed" -> mountedFlyingParameters.setMax_fly_speed(jsonParser.getValueAsInt());
                    case "deceleration_rate" ->
                        mountedFlyingParameters.setDeceleration_rate(jsonParser.getValueAsDouble());
                    case "hover_deceleration_rate" ->
                        mountedFlyingParameters.setHover_deceleration_rate(jsonParser.getValueAsDouble());
                    case "acceleration_rate" ->
                        mountedFlyingParameters.setAcceleration_rate(jsonParser.getValueAsInt());
                    case "strafe_acceleration_rate" ->
                        mountedFlyingParameters.setStrafe_acceleration_rate(jsonParser.getValueAsInt());
                    case "strafe_roll_conversion" ->
                        mountedFlyingParameters.setStrafe_roll_conversion(jsonParser.getValueAsInt());
                    case "turn_rate" -> mountedFlyingParameters.setTurn_rate(jsonParser.getValueAsInt());
                    case "pitch_rate" -> mountedFlyingParameters.setPitch_rate(jsonParser.getValueAsInt());
                    case "stays_horizontal_flying" ->
                        mountedFlyingParameters.setStays_horizontal_flying(jsonParser.getValueAsBoolean());
                    case "gravity_drop_per_tick" ->
                        mountedFlyingParameters.setGravity_drop_per_tick(jsonParser.getValueAsDouble());
                    case "continuous_forward_motion" ->
                        mountedFlyingParameters.setContinuous_forward_motion(jsonParser.getValueAsBoolean());
                    case "continuous_forward_motion_ticks" ->
                        mountedFlyingParameters.setContinuous_forward_motion_ticks(jsonParser.getValueAsInt());
                    case "flying_stamina_charges" ->
                        mountedFlyingParameters.setFlying_stamina_charges(jsonParser.getValueAsInt());
                    case "hover_ticks" -> mountedFlyingParameters.setHover_ticks(jsonParser.getValueAsInt());
                }
            }
            return mountedFlyingParameters;
        }
        return null;

    }

    private FlyingParameters deserializeFlyingParameters(JsonParser jsonParser) throws IOException {
        FlyingParameters flyingParameters = new FlyingParameters();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "flyHeightMin" -> flyingParameters.setFlyHeightMin(jsonParser.getValueAsInt());
                    case "flyHeightMax" -> flyingParameters.setFlyHeightMax(jsonParser.getValueAsInt());
                    case "flySpeedModifier" -> flyingParameters.setFlySpeedModifier(jsonParser.getValueAsDouble());
                    case "flyRefreshRateY" -> flyingParameters.setFlyRefreshRateY(jsonParser.getValueAsInt());
                    case "flyRefreshRateXZ" -> flyingParameters.setFlyRefreshRateXZ(jsonParser.getValueAsInt());
                    case "flyRefreshRateSpeed" -> flyingParameters.setFlyRefreshRateSpeed(jsonParser.getValueAsInt());
                    case "flightTimeMin" -> flyingParameters.setFlightTimeMin(jsonParser.getValueAsInt());
                    case "flightTimeMax" -> flyingParameters.setFlightTimeMax(jsonParser.getValueAsInt());
                    case "flapRate" -> flyingParameters.setFlapRate(jsonParser.getValueAsInt());
                    case "landingMaterials" -> flyingParameters.setLandingMaterials(jsonParser.getValueAsString());
                }
            }
            return flyingParameters;
        }
        return null;
    }

    private RidingOffSets deserializeRidingOffSets(JsonParser jsonParser) throws IOException {
        RidingOffSets ridingOffSets = new RidingOffSets();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "standing" -> {
                        Standing standings = deserializeStandings(jsonParser);
                        ridingOffSets.setStanding(standings);
                    }
                    case "moving" -> {
                        Moving moving = deserializeMovings(jsonParser);
                        ridingOffSets.setMoving(moving);
                    }
                }
            }
            return ridingOffSets;
        }
        return null;
    }

    private Moving deserializeMovings(JsonParser jsonParser) throws IOException {
        Moving moving = new Moving();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "x" -> moving.setX(jsonParser.getValueAsDouble());
                    case "y" -> moving.setY(jsonParser.getValueAsDouble());
                    case "z" -> moving.setZ(jsonParser.getValueAsDouble());
                }
            }
            return moving;
        }
        return null;
    }

    private Standing deserializeStandings(JsonParser jsonParser) throws IOException {
        Standing standing = new Standing();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "x" -> standing.setX(jsonParser.getValueAsDouble());
                    case "y" -> standing.setY(jsonParser.getValueAsDouble());
                    case "z" -> standing.setZ(jsonParser.getValueAsDouble());
                }
            }
            return standing;
        }
        return null;
    }

    private Abilities deserializeAbilities(JsonParser jsonParser) throws IOException {
        Abilities abilities = new Abilities();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "abilities" -> abilities.setAbilities(deserializeStringArray(jsonParser));
                    case "hiddenAbilities" -> abilities.setHiddenAbilities(deserializeStringArray(jsonParser));
                }
            }
            return abilities;
        }
        return null;
    }

    private Dimensions deserializeDimension(JsonParser jsonParser) throws IOException {
        Dimensions dimensions = new Dimensions();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldName) {
                    case "height" -> dimensions.setHeight(jsonParser.getValueAsDouble());
                    case "width" -> dimensions.setWidth(jsonParser.getValueAsDouble());
                    case "length" -> dimensions.setLength(jsonParser.getValueAsInt());
                    case "eyeHeight" -> dimensions.setEyeHeight(jsonParser.getValueAsDouble());
                    case "hoverHeight" -> dimensions.setHoverHeight(jsonParser.getValueAsDouble());
                }
            }
            return dimensions;
        }
        return null;
    }

    private Moves deserializeMoves(JsonParser jsonParser) throws IOException {
        Moves moves = new Moves();
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                if (fieldName.equals("levelUpMoves")) {
                    ArrayList<LevelUpMove> levelUpMoves = deserializeLevelUpMoves(jsonParser);
                    moves.setLevelUpMoves(levelUpMoves);
                } else {
                    ArrayList<String> move = deserializeStringArray(jsonParser);
                    setMovesMove(fieldName, moves, move);
                }
            }
            return moves;
        }

        return null;
    }

    private ArrayList<LevelUpMove> deserializeLevelUpMoves(JsonParser jsonParser) throws IOException {
        ArrayList<LevelUpMove> levelUpMoves = new ArrayList<>();

        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                    LevelUpMove levelUpMove = new LevelUpMove();
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = jsonParser.getCurrentName();
                        jsonParser.nextToken();
                        if (fieldName.equals("level")) {
                            levelUpMove.setLevel(jsonParser.getValueAsInt());
                        } else if (fieldName.equals("attacks")) {
                            ArrayList<String> attacks = deserializeStringArray(jsonParser);
                            levelUpMove.setAttacks(attacks);
                        }
                    }
                    levelUpMoves.add(levelUpMove);
                }
            }
            return levelUpMoves;
        }
        return null;
    }

    private ArrayList<String> deserializeStringArray(JsonParser jsonParser) throws IOException {
        ArrayList<String> string_array = new ArrayList<>();

        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                String forms = jsonParser.getValueAsString();
                string_array.add(forms);
            }
            return string_array;
        }

        return null;
    }

    private void setMovesMove(String fieldName, Moves moves, ArrayList<String> move) {
        switch (fieldName) {
            case "tutorMoves" -> moves.setTutorMoves(move);
            case "eggMoves" -> moves.setEggMoves(move);
            case "tmMoves8" -> moves.setTmMoves8(move);
            case "trMoves" -> moves.setTrMoves(move);
            case "hmMoves" -> moves.setHmMoves(move);
            case "transferMoves" -> moves.setTransferMoves(move);
            case "tmMoves7" -> moves.setTmMoves7(move);
            case "tmMoves6" -> moves.setTmMoves6(move);
            case "tmMoves5" -> moves.setTmMoves5(move);
            case "tmMoves4" -> moves.setTmMoves4(move);
            case "tmMoves3" -> moves.setTmMoves3(move);
            case "tmMoves2" -> moves.setTmMoves2(move);
            case "tmMoves1" -> moves.setTmMoves1(move);
            case "tmMoves" -> moves.setTmMoves(move);
        }
        ;
    }

}
