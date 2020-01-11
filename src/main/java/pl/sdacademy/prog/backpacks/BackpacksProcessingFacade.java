package pl.sdacademy.prog.backpacks;

import java.util.List;

//@RequiredArgsConstructor - konstruktor z finalami
public class BackpacksProcessingFacade {
    private final TestDivider testDivider;
    private final TestExecutionInfoLoader testExecutionInfoLoader;
    private final SplitTestExecutionInfoPersister splitTestExecutionInfoPersister;
    private final BackpackCommandLineParser backpackCommandLineParser;

    public BackpacksProcessingFacade(final TestDivider testDivider,
                                     final TestExecutionInfoLoader testExecutionInfoLoader,
                                     final SplitTestExecutionInfoPersister splitTestExecutionInfoPersister,
                                     final BackpackCommandLineParser backpackCommandLineParser) {
        this.testDivider = testDivider;
        this.testExecutionInfoLoader = testExecutionInfoLoader;
        this.splitTestExecutionInfoPersister = splitTestExecutionInfoPersister;
        this.backpackCommandLineParser = backpackCommandLineParser;
    }

    public void process (final String[] args) {
        backpackCommandLineParser.parse(args);
        final String inputFile = backpackCommandLineParser.getInputFileArgNameValue();
        final String outputDir = backpackCommandLineParser.getOutputDirArgNameValue();
        final int backpacksNum = backpackCommandLineParser.getBackpacksArgValue();

        final List<TestExecutionInfo> loadedInfo = testExecutionInfoLoader.load(inputFile);
        final List<List<TestExecutionInfo>> backpacks = testDivider.divide(loadedInfo, backpacksNum);
        splitTestExecutionInfoPersister.saveSplitBackpacks(backpacks,outputDir);
    }
}
