package pl.sdacademy.prog.jsonDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectC {
    private double valueA;
    private double valueB;
    private List<String> strings;
}
