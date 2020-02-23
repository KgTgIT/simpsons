package it.kgtg.simpsons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.kgtg.simpsons.model.BaseEntity;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@UtilityClass
public class SimpsonUtils {

    private static final String BASE_PATH_TO_FILES = "src/main/resources/data/";

    public static <T extends BaseEntity> List<T> readJSON(String fileName, Class<T> clazz) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(new ClassPathResource(BASE_PATH_TO_FILES + fileName).getPath()));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode phrases = rootNode.get("data");

            return streamOf(phrases.elements()).map(jsonNode -> toObject(objectMapper, jsonNode, clazz))
                                               .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("Could not load initial data from provided JSON files");
        }
    }

    private <T extends BaseEntity> T toObject(ObjectMapper objectMapper, JsonNode jsonNode, Class<T> clazz) {
        try {
            return objectMapper.treeToValue(jsonNode, clazz);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not parse JsonNode into object");
        }
    }

    public static <T> Stream<T> streamOf(Iterator<T> iterator) {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

}
