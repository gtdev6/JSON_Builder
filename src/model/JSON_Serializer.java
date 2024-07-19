package model;

import model.Moves.LevelUpMove;
import model.Moves.Moves;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;

public class JSON_Serializer extends StdSerializer<PrototypeJSON> {
    public JSON_Serializer() {
        this(null);
    }

    public JSON_Serializer(Class<PrototypeJSON> t) {
        super(t);
    }

    @Override
    public void serialize(PrototypeJSON value, JsonGenerator gen, SerializerProvider serializerProvider)
            throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", value.getName());
        gen.writeNumberField("dex", value.getDex());
        serializeArrayWithNewlines(gen, "defaultForms", value.getDefaultForms());
        serializeArrayForm(gen, value.getForms());
        gen.writeNumberField("generation", value.getGeneration());
        gen.writeEndObject();
    }

    private void serializeArrayWithNewlines(JsonGenerator gen, String fieldName, ArrayList<String> values)
            throws IOException {
        gen.writeFieldName(fieldName);
        gen.writeStartArray();
        for (String value : values) {
            gen.writeString(value);
        }
        gen.writeEndArray();
    }

    private void serializeArrayForm(JsonGenerator gen, ArrayList<Form> values) throws IOException {
        gen.writeFieldName("forms");
        gen.writeStartArray();
        for (Form value : values) {
            gen.writeStartObject();
            gen.writeStringField("name", value.getName());
            gen.writeStringField("experienceGroup", value.getExperienceGroup());
            gen.writeObjectField("dimensions", value.getDimensions());
            serializeArrayMoves(gen, value.getMoves());
            gen.writeFieldName("abilities");
            gen.writeStartObject();
            serializeArrayWithNewlines(gen, "abilities", value.getAbilities().getAbilities());
            serializeArrayWithNewlines(gen, "hiddenAbilities", value.getAbilities().getHiddenAbilities());
            gen.writeEndObject();
            gen.writeObjectField("movement", value.getMovement());
            gen.writeObjectField("aggression", value.getAggression());
            gen.writeObjectField("battleStats", value.getBattleStats());
            serializeArrayWithNewlines(gen, "tags", value.getTags());
            gen.writeObjectField("spawn", value.getSpawn());
            serializeArrayWithNewlines(gen, "possibleGenders", value.getPossibleGenders());
            serializeArrayGenderProperties(gen, value.getGenderProperties());
            serializeArrayWithNewlines(gen, "eggGroups", value.getEggGroups());
            serializeArrayWithNewlines(gen, "types", value.getTypes());
            serializeArrayWithNewlines(gen, "preEvolutions", value.getPreEvolutions());
            gen.writeStringField("defaultBaseForm", value.getDefaultBaseForm());
            serializeArrayWithNewlines(gen, "megaItems", value.getMegaItems());
            serializeArrayWithNewlines(gen, "megas", value.getMegas());
            gen.writeObjectField("gigantamax", value.getGigantamax());
            gen.writeNumberField("eggCycles", value.getEggCycles());
            gen.writeNumberField("weight", value.getWeight());
            gen.writeNumberField("catchRate", value.getCatchRate());
            gen.writeNumberField("malePercentage", value.getMalePercentage());
            serializeArrayEvolutions(gen, value.getEvolutions());
            gen.writeObjectField("eyYields", value.getEvYields());
            gen.writeEndObject();

        }
        gen.writeEndArray();
    }

    private void serializeArrayMoves(JsonGenerator gen, Moves move) throws IOException {
        gen.writeFieldName("moves");
        gen.writeStartObject();
        gen.writeFieldName("levelUpMove");
        gen.writeStartArray();
        for (LevelUpMove value : move.getLevelUpMoves()) {
            gen.writeStartObject();
            gen.writeNumberField("level", value.getLevel());
            serializeArrayWithNewlines(gen, "attacks", value.getAttacks());
            gen.writeEndObject();
        }
        gen.writeEndArray();
        serializeArrayWithNewlines(gen, "tutorMoves", move.getTutorMoves());
        serializeArrayWithNewlines(gen, "eggMoves", move.getEggMoves());
        serializeArrayWithNewlines(gen, "tmMoves8", move.getTmMoves8());
        serializeArrayWithNewlines(gen, "trMoves", move.getTrMoves());
        serializeArrayWithNewlines(gen, "hmMoves", move.getHmMoves());
        serializeArrayWithNewlines(gen, "transferMoves", move.getTransferMoves());
        serializeArrayWithNewlines(gen, "tmMoves7", move.getTmMoves7());
        serializeArrayWithNewlines(gen, "tmMoves6", move.getTmMoves6());
        serializeArrayWithNewlines(gen, "tmMoves5", move.getTmMoves5());
        serializeArrayWithNewlines(gen, "tmMoves4", move.getTmMoves4());
        serializeArrayWithNewlines(gen, "tmMoves3", move.getTmMoves3());
        serializeArrayWithNewlines(gen, "tmMoves2", move.getTmMoves2());
        serializeArrayWithNewlines(gen, "tmMoves1", move.getTmMoves1());
        serializeArrayWithNewlines(gen, "tmMoves", move.getTmMoves());
        gen.writeEndObject();

    }

    private void serializeArrayGenderProperties(JsonGenerator gen, ArrayList<GenderProperty> values)
            throws IOException {
        gen.writeFieldName("genderProperties");
        gen.writeStartArray();
        values.forEach(value -> {
            try {
                gen.writeStartObject();
                gen.writeStringField("gender", value.getGender());
                gen.writeFieldName("palettes");
                gen.writeStartArray();
                ArrayList<Palette> palettes = value.getPalettes();
                palettes.forEach(e -> {
                    try {
                        gen.writeStartObject();
                        gen.writeStringField("name", e.getName());
                        gen.writeStringField("texture", e.getTexture());
                        gen.writeStringField("sprite", e.getSprite());
                        gen.writeStringField("sprite", e.getSprite());
                        gen.writeStringField("particle", e.getParticle());
                        if (e.getModelLocator() != null) {
                            gen.writeFieldName("modelLocator");
                            gen.writeStartObject();
                            gen.writeStringField("factoryType", e.getModelLocator().getFactoryType());
                            serializeArrayWithNewlines(gen, "pqc", e.getModelLocator().getPqc());
                            gen.writeNumberField("yRotation", e.getModelLocator().getyRotation());
                            gen.writeEndObject();
                        }
                        if (e.getSounds() != null && !e.getSounds().isEmpty()) {
                            serializeArrayWithNewlines(gen, "sounds", e.getSounds());
                        }
                        gen.writeEndObject();

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                });
                gen.writeEndObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gen.writeEndArray();
    }

    private void serializeArrayEvolutions(JsonGenerator gen, ArrayList<Evolution> values) throws IOException {
        gen.writeFieldName("evolutions");
        gen.writeStartArray();
        values.forEach(value -> {
            try {
                gen.writeStartObject();
                gen.writeNumberField("level", value.getLevel());
                gen.writeStringField("to", value.getTo());
                // serializeArrayWithNewlines(gen,"conditions",value.getConditions());
                gen.writeStringField("evoType", value.getEvoType());
                gen.writeEndObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gen.writeEndArray();
    }

}
