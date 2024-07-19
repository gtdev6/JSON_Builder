package Main;

import EvoConditions.*;
import model.Evolution;
import model.PrototypeJSON;
import model.Form;
import model.Moves.LevelUpMove;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class CustomPrototypeJSONSerializer extends JsonSerializer<PrototypeJSON> {
    @Override
    @SuppressWarnings("unchecked")
    public void serialize(PrototypeJSON prototypeJSON, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();

        // Serialize the "name" and "dex" fields
        rootNode.put("name", prototypeJSON.getName());
        if (prototypeJSON.getDex() != null)
            rootNode.put("dex", prototypeJSON.getDex());

        // Create an ArrayNode for "defaultForms"
        ArrayNode defaultFormsNode = objectMapper.createArrayNode();
        for (String form : prototypeJSON.getDefaultForms()) {
            defaultFormsNode.add(form);
        }
        rootNode.set("defaultForms", defaultFormsNode);

        // Create an ArrayNode for "forms"
        ArrayNode formsNode = objectMapper.createArrayNode();
        for (Form form_value : prototypeJSON.getForms()) {
            // Create an ObjectNode for each form
            ObjectNode formNode = objectMapper.createObjectNode();
            formNode.put("name", form_value.getName());
            if (form_value.getExperienceGroup() != null)
                formNode.put("experienceGroup", form_value.getExperienceGroup());

            // Creating Dimension Node
            ObjectNode dimensionNode = objectMapper.createObjectNode();
            if (form_value.getDimensions() != null) {
                dimensionNode.put("height", form_value.getDimensions().getHeight());
                dimensionNode.put("width", form_value.getDimensions().getWidth());
                dimensionNode.put("length", form_value.getDimensions().getLength());
                dimensionNode.put("eyeHeight", form_value.getDimensions().getEyeHeight());
                dimensionNode.put("hoverHeight", form_value.getDimensions().getHoverHeight());
                formNode.set("dimensions", dimensionNode);
            }
            // Creating Moves
            ObjectNode movesNode = objectMapper.createObjectNode();
            if (form_value.getMoves() != null) {
                ArrayNode levelUpArrayNode = objectMapper.createArrayNode();
                for (LevelUpMove move : form_value.getMoves().getLevelUpMoves()) {
                    ObjectNode levelUpNode = objectMapper.createObjectNode();
                    levelUpNode.put("level", move.getLevel());
                    ArrayNode attackArrayNode = objectMapper.createArrayNode();
                    move.getAttacks().forEach(attackArrayNode::add);
                    levelUpNode.set("attacks", attackArrayNode);

                    levelUpArrayNode.add(levelUpNode);
                }

                ArrayNode tutorMovesArrayNode = objectMapper.createArrayNode();
                ArrayNode eggMoveArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves8ArrayNode = objectMapper.createArrayNode();
                ArrayNode trMovesArrayNode = objectMapper.createArrayNode();
                ArrayNode hmMovesArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves7ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves6ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves5ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves4ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves3ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves2ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMoves1ArrayNode = objectMapper.createArrayNode();
                ArrayNode tmMovesArrayNode = objectMapper.createArrayNode();

                form_value.getMoves().getMoves("tutorMoves").forEach(tutorMovesArrayNode::add);
                form_value.getMoves().getMoves("eggMoves").forEach(eggMoveArrayNode::add);
                form_value.getMoves().getMoves("tmMoves8").forEach(tmMoves8ArrayNode::add);
                form_value.getMoves().getMoves("trMoves").forEach(trMovesArrayNode::add);
                form_value.getMoves().getMoves("hmMoves").forEach(hmMovesArrayNode::add);
                form_value.getMoves().getMoves("tmMoves7").forEach(tmMoves7ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves6").forEach(tmMoves6ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves5").forEach(tmMoves5ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves4").forEach(tmMoves4ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves3").forEach(tmMoves3ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves2").forEach(tmMoves2ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves1").forEach(tmMoves1ArrayNode::add);
                form_value.getMoves().getMoves("tmMoves").forEach(tmMovesArrayNode::add);

                boolean areAllEmpty = levelUpArrayNode.isEmpty() && tutorMovesArrayNode.isEmpty()
                        && eggMoveArrayNode.isEmpty() && tmMoves8ArrayNode.isEmpty()
                        && trMovesArrayNode.isEmpty() && hmMovesArrayNode.isEmpty() && tmMoves7ArrayNode.isEmpty()
                        && tmMoves6ArrayNode.isEmpty()
                        && tmMoves5ArrayNode.isEmpty() && tmMoves4ArrayNode.isEmpty() && tmMoves3ArrayNode.isEmpty()
                        && tmMoves2ArrayNode.isEmpty()
                        && tmMoves1ArrayNode.isEmpty() && tmMovesArrayNode.isEmpty();

                if (!(areAllEmpty)) {
                    movesNode.set("levelUpMoves", levelUpArrayNode);
                    movesNode.set("tutorMoves", tutorMovesArrayNode);
                    movesNode.set("eggMoves", eggMoveArrayNode);
                    movesNode.set("tmMoves8", tmMoves8ArrayNode);
                    movesNode.set("trMoves", trMovesArrayNode);
                    movesNode.set("hmMoves", hmMovesArrayNode);
                    movesNode.set("tmMoves7", tmMoves7ArrayNode);
                    movesNode.set("tmMoves6", tmMoves6ArrayNode);
                    movesNode.set("tmMoves5", tmMoves5ArrayNode);
                    movesNode.set("tmMoves4", tmMoves4ArrayNode);
                    movesNode.set("tmMoves3", tmMoves3ArrayNode);
                    movesNode.set("tmMoves2", tmMoves2ArrayNode);
                    movesNode.set("tmMoves1", tmMoves1ArrayNode);
                    movesNode.set("tmMoves", tmMovesArrayNode);

                    formNode.set("moves", movesNode);
                }
            }

            ArrayNode abilities_ArrayNode = objectMapper.createArrayNode();
            ArrayNode hidden_abilites_ArrayNode = objectMapper.createArrayNode();
            ObjectNode abilitiesNode = objectMapper.createObjectNode();

            if (form_value.getAbilities() != null) {
                form_value.getAbilities().getAbilities().forEach(abilities_ArrayNode::add);
                form_value.getAbilities().getHiddenAbilities().forEach(hidden_abilites_ArrayNode::add);

                abilitiesNode.set("abilities", abilities_ArrayNode);
                abilitiesNode.set("hiddenAbilities", hidden_abilites_ArrayNode);
                formNode.set("abilities", abilitiesNode);
            }

            ObjectNode movementNode = objectMapper.createObjectNode();
            if (form_value.getMovement() != null) {
                movementNode.put("rideable", form_value.getMovement().isRideable());
                movementNode.put("canFly", form_value.getMovement().isCanFly());
                movementNode.put("canSurf", form_value.getMovement().isCanSurf());
                movementNode.put("canRideShoulder", form_value.getMovement().isCanRideShoulder());
                if (form_value.getMovement().getRidingOffSets() != null) {
                    ObjectNode movingNode = objectMapper.createObjectNode();
                    movingNode.put("x", form_value.getMovement().getRidingOffSets().getMoving().getX());
                    movingNode.put("y", form_value.getMovement().getRidingOffSets().getMoving().getY());
                    movingNode.put("z", form_value.getMovement().getRidingOffSets().getMoving().getZ());
                    ObjectNode standingNode = objectMapper.createObjectNode();
                    standingNode.put("x", form_value.getMovement().getRidingOffSets().getStanding().getX());
                    standingNode.put("y", form_value.getMovement().getRidingOffSets().getStanding().getY());
                    standingNode.put("z", form_value.getMovement().getRidingOffSets().getStanding().getZ());
                    ObjectNode ridingOffsetNode = objectMapper.createObjectNode();
                    ridingOffsetNode.set("standing", standingNode);
                    ridingOffsetNode.set("moving", movingNode);
                    movementNode.set("ridingOffSets", ridingOffsetNode);
                }

                formNode.set("movement", movementNode);
            }

            ObjectNode aggressionNode = objectMapper.createObjectNode();
            if (form_value.getAggression() != null) {
                aggressionNode.put("timid", form_value.getAggression().getTimid());
                aggressionNode.put("passive", form_value.getAggression().getPassive());
                aggressionNode.put("aggressive", form_value.getAggression().getAggressive());

                formNode.set("aggression", aggressionNode);
            }

            ObjectNode battle_statsNode = objectMapper.createObjectNode();
            if (form_value.getBattleStats() != null) {
                battle_statsNode.put("hp", form_value.getBattleStats().getHp());
                battle_statsNode.put("attack", form_value.getBattleStats().getAttack());
                battle_statsNode.put("defense", form_value.getBattleStats().getDefense());
                battle_statsNode.put("specialAttack", form_value.getBattleStats().getSpecialAttack());
                battle_statsNode.put("specialDefense", form_value.getBattleStats().getSpecialDefense());
                battle_statsNode.put("speed", form_value.getBattleStats().getSpeed());
                formNode.set("battleStats", battle_statsNode);
            }

            ArrayNode tagsNode = objectMapper.createArrayNode();
            if (form_value.getTags() != null) {
                form_value.getTags().forEach(tagsNode::add);
                formNode.set("tags", tagsNode);
            }

            ObjectNode spawnNode = objectMapper.createObjectNode();
            if (form_value.getSpawn() != null) {
                spawnNode.put("baseExp", form_value.getSpawn().getBaseExp());
                spawnNode.put("baseFriendship", form_value.getSpawn().getBaseFriendship());
                spawnNode.put("spawnLevel", form_value.getSpawn().getSpawnLevel());
                spawnNode.put("spawnLevelRange", form_value.getSpawn().getSpawnLevelRange());
                ArrayNode spawnLocationsNode = objectMapper.createArrayNode();
                form_value.getSpawn().getSpawnLocations().forEach(spawnLocationsNode::add);
                spawnNode.set("spawnLocations", spawnLocationsNode);
                formNode.set("spawn", spawnNode);
            }

            ArrayNode possibleGenderNode = objectMapper.createArrayNode();
            if (form_value.getPossibleGenders() != null || !form_value.getPossibleGenders().isEmpty()) {
                form_value.getPossibleGenders().forEach(possibleGenderNode::add);
                formNode.set("possibleGenders", possibleGenderNode);
            }
            ArrayNode genderPropertiesNode = objectMapper.createArrayNode();

            if (form_value.getGenderProperties() != null) {
                form_value.getGenderProperties().forEach(genderProperty -> {
                    ObjectNode genderPropertyNode = objectMapper.createObjectNode();
                    genderPropertyNode.put("gender", genderProperty.getGender());
                    ArrayNode palettesArrayNode = objectMapper.createArrayNode();
                    genderProperty.getPalettes().forEach(palette -> {
                        ObjectNode paletteNode = objectMapper.createObjectNode();
                        paletteNode.put("name", palette.getName());
                        paletteNode.put("texture", palette.getTexture());
                        paletteNode.put("sprite", palette.getSprite());
                        paletteNode.put("particle", palette.getParticle());
                        if (palette.getModelLocator() != null) {
                            ObjectNode modelLocatorNode = objectMapper.createObjectNode();
                            modelLocatorNode.put("factoryType", palette.getModelLocator().getFactoryType());
                            ArrayNode pqcArrayNode = objectMapper.createArrayNode();
                            palette.getModelLocator().getPqc().forEach(pqcArrayNode::add);
                            modelLocatorNode.set("pqc", pqcArrayNode);
                            if (palette.getModelLocator().getyRotation() != null)
                                modelLocatorNode.put("yRotation", palette.getModelLocator().getyRotation());
                            paletteNode.set("modelLocator", modelLocatorNode);
                        }
                        if (palette.getSounds() != null) {
                            ArrayNode soundsArrayNode = objectMapper.createArrayNode();
                            palette.getSounds().forEach(soundsArrayNode::add);
                            paletteNode.set("sounds", soundsArrayNode);
                        }
                        palettesArrayNode.add(paletteNode);
                    });
                    genderPropertyNode.set("palettes", palettesArrayNode);
                    genderPropertiesNode.add(genderPropertyNode);
                });
                if (!genderPropertiesNode.isEmpty())
                    formNode.set("genderProperties", genderPropertiesNode);
            }

            ArrayNode eggGroups = objectMapper.createArrayNode();
            ArrayNode types = objectMapper.createArrayNode();
            ArrayNode preEvolutions = objectMapper.createArrayNode();
            ArrayNode megaItems = objectMapper.createArrayNode();
            ArrayNode megas = objectMapper.createArrayNode();

            if (form_value.getEggGroups() != null)
                form_value.getEggGroups().forEach(eggGroups::add);
            if (form_value.getTypes() != null)
                form_value.getTypes().forEach(types::add);
            if (form_value.getPreEvolutions() != null)
                form_value.getPreEvolutions().forEach(preEvolutions::add);
            if (form_value.getMegaItems() != null)
                form_value.getMegaItems().forEach(megaItems::add);
            if (form_value.getMegas() != null)
                form_value.getMegas().forEach(megas::add);

            if (!eggGroups.isEmpty())
                formNode.set("eggGroups", eggGroups);
            if (!types.isEmpty())
                formNode.set("types", types);
            if (!preEvolutions.isEmpty())
                formNode.set("preEvolutions", preEvolutions);
            if (!megaItems.isEmpty())
                formNode.set("megaItems", megaItems);
            if (!megas.isEmpty())
                formNode.set("megas", megas);

            ObjectNode giganTamaxNode = objectMapper.createObjectNode();
            if (form_value.getGigantamax() != null) {
                if (form_value.getGigantamax().isCanHaveFactor() != null)
                    giganTamaxNode.put("canHavaFactor", form_value.getGigantamax().isCanHaveFactor());
                if (form_value.getGigantamax().isCanHaveFactor() != null)
                    giganTamaxNode.put("canGigantamax", form_value.getGigantamax().isCanGigantamax());
                if (form_value.getGigantamax().getForm() != null)
                    giganTamaxNode.put("form", form_value.getGigantamax().getForm());
                if (form_value.getGigantamax().getMove() != null)
                    giganTamaxNode.put("move", form_value.getGigantamax().getMove());
            }

            if (form_value.getGigantamax() != null)
                formNode.set("gigantamax", giganTamaxNode);
            if (form_value.getEggCycles() != null)
                formNode.put("eggCycles", form_value.getEggCycles());
            if (form_value.getWeight() != null)
                formNode.put("weight", form_value.getWeight());
            if (form_value.getCatchRate() != null)
                formNode.put("catchRate", form_value.getCatchRate());
            if (form_value.getMalePercentage() != null)
                formNode.put("malePercentage", form_value.getMalePercentage());

            // Evolution Serialization
            ArrayNode evolutionsArrayNode = objectMapper.createArrayNode();
            if (form_value.getEvolutions() != null)
                form_value.getEvolutions().forEach(evolution -> {
                    ObjectNode evolutionNode = objectMapper.createObjectNode();
                    if (evolution.getLevel() != null)
                        evolutionNode.put("level", evolution.getLevel());
                    evolutionNode.put("to", evolution.getTo());
                    ArrayNode conditionsArraynode = objectMapper.createArrayNode();
                    evolution.getConditions().forEach(condition -> {
                        if (condition instanceof LinkedHashMap) {
                            LinkedHashMap<String, Object> condition_linked = (LinkedHashMap<String, Object>) condition;
                            Object o_ = condition_linked.get("evoConditionType");

                            ObjectNode condition_node = handleSerializationForEachCondition(o_.toString(), objectMapper,
                                    condition_linked);
                            conditionsArraynode.add(condition_node);
                        } else {
                            ObjectNode condition_node = handleEachCondition(Evolution.getConditionObjectType(condition),
                                    objectMapper, condition);
                            conditionsArraynode.add(condition_node);
                        }
                    });

                    evolutionNode.set("conditions", conditionsArraynode);
                    evolutionNode.put("evoType", evolution.getEvoType());
                    if (evolution.getMoves() != null) {
                        ArrayNode move_evolution_node = objectMapper.createArrayNode();
                        evolution.getMoves().forEach(move_evolution_node::add);
                        evolutionNode.set("moves", move_evolution_node);
                    }
                    evolutionsArrayNode.add(evolutionNode);
                });
            if (!evolutionsArrayNode.isEmpty())
                formNode.set("evolutions", evolutionsArrayNode);
            ObjectNode evYieldsNode = objectMapper.createObjectNode();
            if (form_value.getEvYields() != null) {
                setEvYieldFields(form_value, evYieldsNode);
                formNode.set("evYields", evYieldsNode);
            }

            formsNode.add(formNode);
        }
        rootNode.set("forms", formsNode);

        // Serialize the "generation" field
        rootNode.put("generation", prototypeJSON.getGeneration());

        // Write the JSON object to the generator
        gen.writeObject(rootNode);
    }

    private static void setEvYieldFields(Form form_value, ObjectNode evYieldsNode) {
        if (form_value.getEvYields().getHp() != null)
            evYieldsNode.put("hp", form_value.getEvYields().getHp());
        if (form_value.getEvYields().getAttack() != null)
            evYieldsNode.put("attack", form_value.getEvYields().getAttack());
        if (form_value.getEvYields().getDefense() != null)
            evYieldsNode.put("defense", form_value.getEvYields().getDefense());
        if (form_value.getEvYields().getSpecialAttack() != null)
            evYieldsNode.put("specialAttack", form_value.getEvYields().getSpecialAttack());
        if (form_value.getEvYields().getSpecialDefense() != null)
            evYieldsNode.put("specialDefense", form_value.getEvYields().getSpecialDefense());
        if (form_value.getEvYields().getSpeed() != null)
            evYieldsNode.put("speed", form_value.getEvYields().getSpeed());
    }

    @SuppressWarnings("unchecked")
    private static ObjectNode handleSerializationForEachCondition(String condition, ObjectMapper objectMapper,
            HashMap<String, Object> hash_obj) {
        switch (condition) {
            case ("biome") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ArrayNode biomeList = objectMapper.createArrayNode();
                ((ArrayList<String>) hash_obj.get("biomes")).forEach(biomeList::add);
                obj.set("biomes", biomeList);
                obj.put("evoConditionType", "biome");
                return obj;
            }
            case ("blocksWalkedOutsideBall") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("blocksToWalk", Integer.parseInt(String.valueOf(hash_obj.get("blocksToWalk"))));
                obj.put("evoConditionType", "blocksWalkedOutsideBall");
                return obj;
            }
            case ("chance") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ;
                obj.put("chance", Integer.valueOf(String.valueOf(hash_obj.get("chance"))));
                obj.put("evoConditionType", "chance");
                return obj;
            }
            case ("critical") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("critical", Integer.parseInt(hash_obj.get("critical").toString()));
                obj.put("evoConditionType", "critical");
                return obj;
            }
            case ("evolutionRock") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("evolutionRock", hash_obj.get("evolutionRock").toString());
                obj.put("maxRangeSquared", Integer.valueOf(hash_obj.get("maxRangeSquared").toString()));
                obj.put("evoConditionType", "evoRock");
                return obj;
            }
            case ("evolutionScroll") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("evolutionScroll", hash_obj.get("evolutionScroll").toString());
                obj.put("maxRangeSquared", Integer.valueOf(hash_obj.get("maxRangeSquared").toString()));
                obj.put("evoConditionType", "evolutionScroll");
                return obj;
            }
            case ("friendship") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("friendship", Integer.valueOf(hash_obj.get("friendship").toString()));
                obj.put("evoConditionType", "friendship");
                return obj;
            }
            case ("gender") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ArrayNode genderList = objectMapper.createArrayNode();
                ((ArrayList<String>) hash_obj.get("genders")).forEach(genderList::add);
                obj.set("genders", genderList);
                obj.put("evoConditionType", "gender");
                return obj;
            }
            case ("healthAbsence") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("health", Integer.valueOf(hash_obj.get("health").toString()));
                obj.put("evoConditionType", "healthAbsence");
                return obj;
            }
            case ("heldItem") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ObjectNode item = objectMapper.createObjectNode();
                item.put("itemID", ((HashMap<String, Object>) hash_obj.get("item")).get("itemID").toString());
                obj.set("item", item);
                obj.put("evoConditionType", "heldItem");
                return obj;
            }
            case ("highAltitude") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("minAltitude", Double.parseDouble(String.valueOf(hash_obj.get("minAltitude"))));
                obj.put("evoConditionType", "highAltitude");
                return obj;
            }
            case ("level") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("level", Integer.valueOf(String.valueOf(hash_obj.get("level"))));
                obj.put("evoConditionType", "level");
                return obj;
            }
            case ("moonPhase") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("moonPhase", Integer.valueOf(String.valueOf(hash_obj.get("moonPhase"))));
                obj.put("evoConditionType", "moonPhase");
                return obj;
            }
            case ("move") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("attackName", hash_obj.get("attackName").toString());
                obj.put("evoConditionType", "move");
                return obj;
            }
            case ("moveType") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("type", hash_obj.get("type").toString());
                obj.put("evoConditionType", "move");
                return obj;
            }
            case ("moveUses") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("uses", Integer.valueOf(String.valueOf(hash_obj.get("uses"))));
                obj.put("evoConditionType", "moveUses");
                return obj;
            }
            case ("nature") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ArrayNode natureList = objectMapper.createArrayNode();
                ArrayList<String> nature_arraylist = (ArrayList<String>) hash_obj.get("natures");
                if (nature_arraylist != null)
                    nature_arraylist.forEach(natureList::add);
                obj.set("natures", natureList);
                obj.put("evoConditionType", "nature");
                return obj;
            }
            case ("nugget") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("nuggets", Integer.valueOf(String.valueOf(hash_obj.get("nuggets"))));
                obj.put("evoConditionType", "nugget");
                return obj;
            }
            case ("party") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ArrayNode form_List = objectMapper.createArrayNode();
                ArrayNode palette_List = objectMapper.createArrayNode();
                ArrayNode pokemon_List = objectMapper.createArrayNode();
                ArrayNode type_list = objectMapper.createArrayNode();
                ArrayList<String> form_arraylist = (ArrayList<String>) hash_obj.get("withForms");
                ArrayList<String> type_arraylist = (ArrayList<String>) hash_obj.get("withTypes");
                ArrayList<String> pokemon_arraylist = (ArrayList<String>) hash_obj.get("withPokemon");
                ArrayList<String> palette_arraylist = (ArrayList<String>) hash_obj.get("withPalettes");
                if (form_arraylist != null)
                    form_arraylist.forEach(form_List::add);
                if (type_arraylist != null)
                    type_arraylist.forEach(palette_List::add);
                if (pokemon_arraylist != null)
                    pokemon_arraylist.forEach(pokemon_List::add);
                if (palette_arraylist != null)
                    palette_arraylist.forEach(type_list::add);
                obj.set("withPokemon", pokemon_List);
                obj.set("withTypes", type_list);
                obj.set("withForms", form_List);
                if (!palette_List.isEmpty())
                    obj.set("withPalettes", palette_List);
                obj.put("evoConditionType", "party");
                return obj;
            }
            case ("potionEffect") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                ArrayNode potion_list = objectMapper.createArrayNode();
                ArrayList<String> potion_arraylist = (ArrayList<String>) hash_obj.get("potions");
                if (potion_arraylist != null)
                    potion_arraylist.forEach(potion_list::add);
                obj.set("potions", potion_list);
                obj.put("evoConditionType", "potionEffect");
                return obj;
            }
            case ("recoil") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("recoil", Integer.valueOf(String.valueOf(hash_obj.get("recoil"))));
                obj.put("evoConditionType", "recoil");
                return obj;
            }
            case ("shiny") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("evoConditionType", "shiny");
                obj.put("shiny", Boolean.valueOf(hash_obj.get("shiny").toString()));
                return obj;
            }
            case ("statRatio") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("ratio", Double.parseDouble(String.valueOf(hash_obj.get("ratio"))));
                obj.put("stat1", String.valueOf(hash_obj.get("stat1")));
                obj.put("stat2", String.valueOf(hash_obj.get("stat2")));
                obj.put("evoConditionType", "statRatio");
                return obj;
            }
            case ("status") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("type", String.valueOf(hash_obj.get("type")));
                obj.put("evoConditionType", "status");
                return obj;
            }
            case ("time") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("time", String.valueOf(hash_obj.get("time")));
                obj.put("evoConditionType", "time");
                return obj;
            }
            case ("weather") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("weather", String.valueOf(hash_obj.get("weather")));
                obj.put("evoConditionType", "weather");
                return obj;
            }
            case ("withinStructure") -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("structure", String.valueOf(hash_obj.get("structure")));
                obj.put("evoConditionType", "withinStructure");
                return obj;
            }
            default -> {
                ObjectNode obj = objectMapper.createObjectNode();
                obj.put("evoConditionType", hash_obj.get("evoConditionType").toString());
                return obj;
            }
        }

    }

    public static ObjectNode handleEachCondition(String condition, ObjectMapper obj, Object condition_object) {
        switch (condition) {
            case "battleCritical" -> {
                BattleCriticalCondition battleCriticalCondition = (BattleCriticalCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("critical", battleCriticalCondition.getCritical());
                obj_node.put("evoConditionType", battleCriticalCondition.evoConditionType);
                return obj_node;
            }
            case "biome" -> {
                BiomeCondition biomeCondition = (BiomeCondition) condition_object;
                ArrayNode arrayNode = obj.createArrayNode();
                if (biomeCondition.getBiomes() != null) {
                    biomeCondition.getBiomes().forEach(arrayNode::add);
                }
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.set("biomes", arrayNode);
                obj_node.put("evoConditionType", biomeCondition.getEvoConditionType());
                return obj_node;
            }
            case "blocksWalkedOutsideBall" -> {
                BlocksWalkedOutsideBallCondition blocksWalkedOutsideBallCondition = (BlocksWalkedOutsideBallCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("biomes", blocksWalkedOutsideBallCondition.getBlocksToWalk());
                obj_node.put("evoConditionType", blocksWalkedOutsideBallCondition.evoConditionType);
                return obj_node;
            }
            case "chance" -> {
                ChanceCondition chanceCondition = (ChanceCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("chance", chanceCondition.getChance());
                obj_node.put("evoConditionType", chanceCondition.evoConditionType);
                return obj_node;
            }
            case "evoRock" -> {
                EvoRockCondition evoRockCondition = (EvoRockCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("evolutionRock", evoRockCondition.getEvolutionRock().toString());
                obj_node.put("maxRangeSquared", evoRockCondition.getMaxRangeSquared());
                obj_node.put("evoConditionType", evoRockCondition.evoConditionType);
                return obj_node;
            }
            case "evoScroll" -> {
                EvoScrollCondition evoScrollCondition = (EvoScrollCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("evolutionScroll", evoScrollCondition.getEvolutionScroll().toString());
                obj_node.put("maxRangeSquared", evoScrollCondition.getMaxRangeSquared());
                obj_node.put("evoConditionType", evoScrollCondition.evoConditionType);
                return obj_node;
            }
            case "friendship" -> {
                FriendshipCondition friendshipCondition = (FriendshipCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("friendship", friendshipCondition.getFriendship());
                obj_node.put("evoConditionType", friendshipCondition.evoConditionType);
                return obj_node;
            }
            case "gender" -> {
                GenderCondition genderCondition = (GenderCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                ArrayNode arrayNode = obj.createArrayNode();
                if (genderCondition.getGenders() != null) {
                    genderCondition.getGenders().forEach(arrayNode::add);
                }
                obj_node.set("genders", arrayNode);
                obj_node.put("evoConditionType", genderCondition.evoConditionType);
                return obj_node;
            }
            case "healthAbsence" -> {
                HealthAbsenceCondition healthAbsenceCondition = (HealthAbsenceCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("health", healthAbsenceCondition.getHealth());
                obj_node.put("evoConditionType", healthAbsenceCondition.evoConditionType);
                return obj_node;
            }
            case "heldItem" -> {
                HeldItemCondition heldItemCondition = (HeldItemCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                ObjectNode item = obj.createObjectNode();
                item.put("itemID", heldItemCondition.getItem().getItemID());
                obj_node.set("item", item);
                obj_node.put("evoConditionType", heldItemCondition.evoConditionType);
                return obj_node;
            }
            case "highAltitude" -> {
                HighAltitudeCondition highAltitudeCondition = (HighAltitudeCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("minAltitude", highAltitudeCondition.getMinAltitude());
                obj_node.put("evoConditionType", highAltitudeCondition.evoConditionType);
                return obj_node;
            }
            case "level" -> {
                LevelCondition levelCondition = (LevelCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("level", levelCondition.getLevel());
                obj_node.put("evoConditionType", levelCondition.evoConditionType);
                return obj_node;
            }
            case "moonPhase" -> {
                MoonPhaseCondition moonPhaseCondition = (MoonPhaseCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("moonPhase", moonPhaseCondition.getMoonPhase());
                obj_node.put("evoConditionType", moonPhaseCondition.evoConditionType);
                return obj_node;
            }
            case "move" -> {
                MoveCondition moveCondition = (MoveCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("attackName", moveCondition.getAttackName());
                obj_node.put("evoConditionType", moveCondition.evoConditionType);
                return obj_node;
            }
            case "moveType" -> {
                MoveTypeCondition moveTypeCondition = (MoveTypeCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("type", moveTypeCondition.getType());
                obj_node.put("evoConditionType", moveTypeCondition.evoConditionType);
                return obj_node;
            }
            case "moveUses" -> {
                MoveUsesCondition moveUsesCondition = (MoveUsesCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("uses", moveUsesCondition.getUses());
                obj_node.put("evoConditionType", moveUsesCondition.evoConditionType);
                return obj_node;
            }
            case "nature" -> {
                NatureCondition natureCondition = (NatureCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                ArrayNode arrayNode = obj.createArrayNode();
                if (natureCondition.getNatures() != null) {
                    natureCondition.getNatures().forEach(arrayNode::add);
                }
                obj_node.set("natures", arrayNode);
                obj_node.put("evoConditionType", natureCondition.evoConditionType);
                return obj_node;
            }
            case "nugget" -> {
                NuggetCondition nuggetCondition = (NuggetCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("nuggets", nuggetCondition.getNuggets());
                obj_node.put("evoConditionType", nuggetCondition.evoConditionType);
                return obj_node;
            }
            case "party" -> {
                PartyCondition partyCondition = (PartyCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                ArrayNode formArrayNode = obj.createArrayNode();
                ArrayNode paletteArrayNode = obj.createArrayNode();
                ArrayNode pokemonArrayNode = obj.createArrayNode();
                ArrayNode typeArrayNode = obj.createArrayNode();
                if (partyCondition.getWithForms() != null) {
                    partyCondition.getWithForms().forEach(formArrayNode::add);
                }
                if (partyCondition.getWithPalettes() != null) {
                    partyCondition.getWithPalettes().forEach(paletteArrayNode::add);
                }
                if (partyCondition.getWithPokemon() != null) {
                    partyCondition.getWithPokemon().forEach(pokemonArrayNode::add);
                }
                if (partyCondition.getWithTypes() != null) {
                    partyCondition.getWithTypes().forEach(typeArrayNode::add);
                }

                obj_node.set("withForms", formArrayNode);
                if (!paletteArrayNode.isEmpty())
                    obj_node.set("withPalettes", paletteArrayNode);
                obj_node.set("withPokemon", pokemonArrayNode);
                obj_node.set("withTypes", typeArrayNode);
                obj_node.put("evoConditionType", partyCondition.evoConditionType);
                return obj_node;
            }
            case "potionEffect" -> {
                PotionEffectCondition potionEffectCondition = (PotionEffectCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                ArrayNode arrayNode = obj.createArrayNode();
                if (potionEffectCondition.getPotions() != null) {
                    potionEffectCondition.getPotions().forEach(arrayNode::add);
                }
                obj_node.set("potions", arrayNode);
                obj_node.put("evoConditionType", potionEffectCondition.evoConditionType);
                return obj_node;
            }
            case "recoil" -> {
                RecoilCondition recoilCondition = (RecoilCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("recoil", recoilCondition.getRecoil());
                obj_node.put("evoConditionType", recoilCondition.evoConditionType);
                return obj_node;
            }
            case "shiny" -> {
                ShinyCondition shinyCondition = (ShinyCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("shiny", shinyCondition.isShiny());
                obj_node.put("evoConditionType", shinyCondition.evoConditionType);
                return obj_node;
            }
            case "statRatio" -> {
                StatRatioCondition statRatioCondition = (StatRatioCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("ratio", statRatioCondition.getRatio());
                obj_node.put("stat1", statRatioCondition.getStat1());
                obj_node.put("stat2", statRatioCondition.getStat2());
                obj_node.put("evoConditionType", statRatioCondition.evoConditionType);
                return obj_node;
            }
            case "time" -> {
                TimeCondition timeCondition = (TimeCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("time", timeCondition.getTime());
                obj_node.put("evoConditionType", timeCondition.evoConditionType);
                return obj_node;
            }
            case "weather" -> {
                WeatherCondition weatherCondition = (WeatherCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("weather", weatherCondition.getWeather());
                obj_node.put("evoConditionType", weatherCondition.evoConditionType);
                return obj_node;
            }
            case "withinStructure" -> {
                WithinStructureCondition withinStructureCondition = (WithinStructureCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("structure", withinStructureCondition.getStructure());
                obj_node.put("evoConditionType", withinStructureCondition.evoConditionType);
                return obj_node;
            }
            default -> {
                EvoCondition evoCondition = (EvoCondition) condition_object;
                ObjectNode obj_node = obj.createObjectNode();
                obj_node.put("evoConditionType", evoCondition.getEvoConditionType());
                return obj_node;
            }
        }

    }

}
