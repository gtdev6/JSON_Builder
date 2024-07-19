package model;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Main.CustomPrototypeJSONDeserializer;
import Main.CustomPrototypeJSONSerializer;

public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Create a custom module to register the custom array serializer
        SimpleModule customModule = new SimpleModule();
        customModule.addSerializer(PrototypeJSON.class, new CustomPrototypeJSONSerializer());
        customModule.addDeserializer(PrototypeJSON.class, new CustomPrototypeJSONDeserializer());

        defaultObjectMapper.registerModule(customModule);
        return defaultObjectMapper;
    }

    public static JsonNode parse(File src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <T> T formJson(JsonNode node, Class<T> clazz) throws IOException {
        return objectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object a) {
        return objectMapper.valueToTree(a);
    }

    public static String stringifyJson(JsonNode node) throws JsonProcessingException {
        return prettyPrint(node, false);
    }

    public static String prettyPrint(JsonNode node, boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        if (pretty)
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        return objectWriter.writeValueAsString(node);
    }

}
