package pl.sdacademy.prog.jsonDemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjectF {
    private String fieldA;
    private Double fieldB;
    private Set<String> setValues;
    private LinkedList<String> linkedList;
    private ObjectA objectA;
    private ObjectE objectE;
}
