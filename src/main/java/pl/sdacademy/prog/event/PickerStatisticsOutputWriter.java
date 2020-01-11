package pl.sdacademy.prog.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.OutputStream;
import java.util.List;

public class PickerStatisticsOutputWriter {
    private final ObjectMapperFactory objectMapperFactory;

    public PickerStatisticsOutputWriter(final ObjectMapperFactory objectMapperFactory) {
        this.objectMapperFactory = objectMapperFactory;
    }

    @SneakyThrows
    public void writeStatistics (final List<PickerStatistics> statistics,
                                 final OutputStream outputStream) {
        final ObjectMapper commonObjectMapper = objectMapperFactory.createCommonObjectMapper();
        outputStream.write(commonObjectMapper.writeValueAsBytes(statistics));
    }
}
