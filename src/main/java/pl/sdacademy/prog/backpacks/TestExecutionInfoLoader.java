package pl.sdacademy.prog.backpacks;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.prog.stra.GenericException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class TestExecutionInfoLoader {
    private static final int EXPECTED_LINE_ELEMENTS_NUM = 2;
    private static final int TEST_NAME_INDEX = 0;
    private static final int TEST_EXECUTION_TIME_INDEX = 1;
    private static final String DATA_SEPARATOR = ":";

    public List<TestExecutionInfo> load (final String filePath){
        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.lines()
                    .map(this::linesToTestExecutionInfo)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (IOException exp) {
            throw new GenericException("Cannot read input file " + filePath, exp);
        }
    }

    private Optional<TestExecutionInfo> linesToTestExecutionInfo (final String line) {
        final String[] splitLines = line.split(DATA_SEPARATOR);
        if (splitLines.length != EXPECTED_LINE_ELEMENTS_NUM
                || !splitLines[TEST_EXECUTION_TIME_INDEX].matches("[0-9]+")){
            log.warn("Line has incorrect format");
            return Optional.empty();
        }
        final String testName = splitLines[TEST_NAME_INDEX];
        final Long executionTime = Long.parseLong(splitLines[TEST_EXECUTION_TIME_INDEX]);
        return Optional.of(new TestExecutionInfo(testName, executionTime));
    }
}
