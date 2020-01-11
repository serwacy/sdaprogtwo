package pl.sdacademy.prog.chainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    private String name;
    private UUID value;
    private LocalDateTime expirationTime;
}
