package pl.sdacademy.prog.strategy;

import pl.sdacademy.prog.stra.GenericException;

import java.io.*;
import java.util.stream.Collectors;

public class FileContentProvider {
    public String readContent (final String path) {
        try(final BufferedReader bufferedReader
                = new BufferedReader(new FileReader(new File(path)))){
            return bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
        } catch (final IOException exp){
            throw new GenericException("Cannot read file content", exp);
        }
    }
}
