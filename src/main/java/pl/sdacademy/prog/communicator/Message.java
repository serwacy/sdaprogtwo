package pl.sdacademy.prog.communicator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.SimpleTimeZone;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    private String value;
    private LocalDateTime createdAt;
    private String username;

    public String getReadable(){
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        return createdAt.format(dateTimeFormatter) + " " + username + "\n" + value;
    }
}
