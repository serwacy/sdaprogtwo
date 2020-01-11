package pl.sdacademy.prog.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TextProcessingFacadeTest {
    @Mock
    private CustomCommandLineParser commandLineParser;
    @Mock
    private FileContentProvider contentProvider;
    @Mock
    private ConversionStrategyProvider strategyProvider;
    @InjectMocks
    private TextProcessingFacade textProcessingFacade;

    @Captor
    private ArgumentCaptor<String> captor;
    @Mock
    private TextConversionStrategy textConversionStrategy;

    @Test
    void shouldProvideProperModificationStrategy() {
        final String[] args = new String[] {"-t=KEBAB_CASE",
                "-f=C:\\Users\\Grzegorz\\IdeaProjects\\sdaprogtwo\\src\\main\\resources\\textToConvert.txt"};
        doNothing().when(commandLineParser).parse(args);
        when(commandLineParser.getConversionTypeArgValue())
                .thenReturn(ConversionType.KEBAB_CASE);
        when(commandLineParser.getFilePathArgValue()).
                thenReturn("C:\\Users\\Grzegorz\\IdeaProjects\\sdaprogtwo\\src\\main\\resources\\textToConvert.txt");
        when(contentProvider
                .readContent("C:\\Users\\Grzegorz\\IdeaProjects\\sdaprogtwo\\src\\main\\resources\\textToConvert.txt"))
                .thenReturn("someFileContent");
        when(strategyProvider.getStrategy(ConversionType.KEBAB_CASE))
                .thenReturn(textConversionStrategy);
        when(textConversionStrategy.modify("someFileContent"))
                .thenReturn("output");

        textProcessingFacade.process(args);

        verify(textConversionStrategy).modify(captor.capture());
        assertThat(captor.getValue()).isEqualTo("someFileContent");
    }
}