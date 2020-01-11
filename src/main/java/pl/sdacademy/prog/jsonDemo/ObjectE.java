package pl.sdacademy.prog.jsonDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectE {
    private String str;
    private Map<String, String> someMap;
}
