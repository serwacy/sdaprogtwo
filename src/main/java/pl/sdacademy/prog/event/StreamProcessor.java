package pl.sdacademy.prog.event;

import javax.annotation.WillNotClose;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StreamProcessor {
    void process(@WillNotClose InputStream source, @WillNotClose OutputStream sink) throws IOException;
}
