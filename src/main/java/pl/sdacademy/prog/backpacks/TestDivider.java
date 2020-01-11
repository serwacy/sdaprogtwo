package pl.sdacademy.prog.backpacks;

import pl.sdacademy.prog.stra.GenericException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDivider {
    public List<List<TestExecutionInfo>> divide (final List<TestExecutionInfo> testExecutionInfoList,
                                                 final int backpacksNumber){
        final List<List<TestExecutionInfo>> backpacks = getEmptyBackpacks(backpacksNumber);

        for (final TestExecutionInfo testExecutionInfo : testExecutionInfoList) {
            final List<Long> sumOfExecutionTimes = getExecutionTimePerBackpack(backpacks);
            final int indexToAddNextElement = calculatedIndexOfNextBackpack(sumOfExecutionTimes);
            backpacks.get(indexToAddNextElement).add(testExecutionInfo);
        }

        return backpacks;
    }
    private List<List<TestExecutionInfo>> getEmptyBackpacks (final int backpacksNumber){
        return Stream
                .generate(() -> new ArrayList<TestExecutionInfo>())
                .limit(backpacksNumber)
                .collect(Collectors.toList());
    }
    private List<Long> getExecutionTimePerBackpack (final List<List<TestExecutionInfo>> backpacks){
        return backpacks.stream()
                .map(this::sumExecutionTime)
                .collect(Collectors.toList());
    }
    private Long sumExecutionTime (final List<TestExecutionInfo> testExecutionInfoList) {
        return testExecutionInfoList.stream().mapToLong(TestExecutionInfo::getExecutionTime).sum();
    }
    private int calculatedIndexOfNextBackpack (final List<Long> sumOfExecutionTimes){
        final Optional<Long> minimumExecutionTime = sumOfExecutionTimes.stream()
                .min(Comparator.naturalOrder());
        if (minimumExecutionTime.isEmpty()) {
            throw new GenericException("Could not find minimum value");
        }
        return sumOfExecutionTimes.indexOf(minimumExecutionTime.get());
    }
}
