package pl.sdacademy.prog.jsonDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ObjectX {
    @JsonProperty("str-a")
    private String stringA;
    @JsonProperty("val-x")
    private int valueX;
    private List<String> strings;

    @JsonIgnore
    public String getSomething() {
        return "randomString";
    }
    @JsonIgnore
    public boolean isValid(){
        return true;
    }
}
