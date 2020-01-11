package pl.sdacademy.prog.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pick {
    @JsonProperty("article_name")
    private String articleName;
    @JsonProperty("timestamp")
    private String timestamp;
}
