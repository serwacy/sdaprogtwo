package pl.sdacademy.prog.chainOfResponsibility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordEncoder {
    private static final BCryptPasswordEncoder INSTANCE = new BCryptPasswordEncoder();

    public static BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return INSTANCE;
    }
}
