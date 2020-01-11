package pl.sdacademy.prog.backpacks;

public class BackpacksMain {
    public static void main(String[] args) {
        BackpacksProcessingFacade backpacksProcessingFacade =
                new BackpacksProcessingFacade(new TestDivider(),
                        new TestExecutionInfoLoader(),
                        new SplitTestExecutionInfoPersister(),
                        new BackpackCommandLineParser());
        backpacksProcessingFacade.process(args);
//        -f=C:\Users\Grzegorz\IdeaProjects\sdaprogtwo\src\main\resources\testTimes.txt
//        -o=C:\Users\Grzegorz\IdeaProjects\sdaprogtwo\src\main\resources\testTimesBackpack
//        -n=4

//        final String inputFile = args[0];
//        final String outputDir = args[1];
//        final int backpacksNum = Integer.parseInt(args[2]);
//
//        final TestExecutionInfoLoader loader = new TestExecutionInfoLoader();
//        final TestDivider testDivider = new TestDivider();
//        final SplitTestExecutionInfoPersister persister = new SplitTestExecutionInfoPersister();
//
//        final List<TestExecutionInfo> inputTests = loader.load(inputFile);
//        final List<List<TestExecutionInfo>> splitTests = testDivider.divide(inputTests, backpacksNum);
//        persister.saveSplitBackpacks(splitTests, outputDir);
    }
}
