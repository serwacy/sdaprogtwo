package pl.sdacademy.prog.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PickEventMapper {
    private final ObjectMapperFactory objectMapperFactory;

    public PickEventMapper(final ObjectMapperFactory objectMapperFactory) {
        this.objectMapperFactory = objectMapperFactory;
    }

    public Optional<PickEvent> toPickEvent(final List<Byte> eventAsBytes){
        final ObjectMapper commonObjectMapper = objectMapperFactory.createCommonObjectMapper();
        try {
            return Optional.of(commonObjectMapper
                    .readValue(ArrayUtils.toPrimitive(eventAsBytes.toArray(Byte[]::new)), PickEvent.class));
        } catch (IOException exp) {
            return Optional.empty();
        }
    }
}
