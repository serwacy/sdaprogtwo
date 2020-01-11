package pl.sdacademy.prog.backpacks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestExecutionInfo {
    private String testName;
    private Long executionTime;
}
