package pl.sdacademy.prog.event;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
    public ObjectMapper createCommonObjectMapper(){
        return new ObjectMapper();
    }
}
