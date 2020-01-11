package pl.sdacademy.prog.jsonDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonMain2 {
    public static void main(String[] args) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();

        final ObjectX objectX = new ObjectX("random", 182, List.of());
        final String output = objectMapper.writeValueAsString(objectX);
        System.out.println(output);
    }
}
