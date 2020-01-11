package pl.sdacademy.prog.jsonDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class JsonMain {
    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();

        final ObjectA objectA = new ObjectA("andrew");
        final String stringA = objectMapper.writeValueAsString(objectA);
        System.out.println(stringA);
        final ObjectA objectA1 = objectMapper.readValue(stringA, ObjectA.class);

        final ObjectB objectB1 = new ObjectB(2, 3);
        final ObjectB objectB2 = new ObjectB(3, null);
        System.out.println(objectMapper.writeValueAsString(objectB1));
        System.out.println(objectMapper.writeValueAsString(objectB2));

        final ObjectC objectC = new ObjectC(2D, 2.3, List.of("stra", "strb", "strc"));
        final String stringC = objectMapper.writeValueAsString(objectC);
        System.out.println(stringC);
        final ObjectC objectC1 = objectMapper.readValue(stringC, ObjectC.class);

        final ObjectD objectD = new ObjectD(2.3F);
        System.out.println(objectMapper.writeValueAsString(objectD));

        final ObjectE objectE = new ObjectE("sth", Map.of("key1", "value1", "key2", "value2"));
        System.out.println(objectMapper.writeValueAsString(objectE));

        final ObjectF objectF = ObjectF.builder()
                .fieldA("someA")
                .fieldB(2.3)
                .setValues(Set.of("sv1", "sv2"))
                .linkedList(new LinkedList<>(Arrays.asList("ll1", "ll2")))
                .objectA(objectA)
                .objectE(objectE)
                .build();
        System.out.println(objectMapper.writeValueAsString(objectF));
    }
}
