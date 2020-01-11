package pl.sdacademy.prog.backpacks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BackpacksProcessingFacadeTest {
    @Mock
    private TestDivider testDivider;
    @Mock
    private TestExecutionInfoLoader testExecutionInfoLoader;
    @Mock
    private SplitTestExecutionInfoPersister splitTestExecutionInfoPersister;
    @Mock
    private BackpackCommandLineParser backpackCommandLineParser;
    @InjectMocks
    private BackpacksProcessingFacade backpacksProcessingFacade;

    @Test
    void shouldProcessBackpackSplit(){
        final int backpackNum = 4;
        final String input = "/input";
        final String output = "/output";
        final TestExecutionInfo testExecutionInfoA = new TestExecutionInfo("test1", 1L);
        final TestExecutionInfo testExecutionInfoB = new TestExecutionInfo("test2", 2L);
        final List<TestExecutionInfo> list = List.of(testExecutionInfoA, testExecutionInfoB);
        final List<List<TestExecutionInfo>> testExecutionInfoListList =
                List.of(List.of(testExecutionInfoA), List.of(testExecutionInfoB));
        doNothing().when(backpackCommandLineParser).parse(any());
        when(backpackCommandLineParser.getBackpacksArgValue()).thenReturn(backpackNum);
        when(backpackCommandLineParser.getInputFileArgNameValue()).thenReturn(input);
        when(backpackCommandLineParser.getOutputDirArgNameValue()).thenReturn(output);
        when(testExecutionInfoLoader.load(input)).thenReturn(list);
        when(testDivider.divide(list, backpackNum)).thenReturn(testExecutionInfoListList);
        doNothing().when(splitTestExecutionInfoPersister).saveSplitBackpacks(testExecutionInfoListList, output);

        backpacksProcessingFacade.process(null);
    }
}