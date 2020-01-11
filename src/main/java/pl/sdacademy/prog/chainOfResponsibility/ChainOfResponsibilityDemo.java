package pl.sdacademy.prog.chainOfResponsibility;

import java.time.LocalDateTime;
import java.util.UUID;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        final UserCredentialsRepository userCredentialsRepository = new UserCredentialsRepository();
        final UserCredentialsService userCredentialsService = new UserCredentialsService(
                PasswordEncoder.getBCryptPasswordEncoder(),
                userCredentialsRepository);
        //final UserCredentials userCredentials = new UserCredentials("Andrzej", "andy_123");

        final TokenRepository tokenRepository = new TokenRepository();
        final TokenService tokenService = new TokenService(tokenRepository);
        //final Token token = new Token("Grażyna", UUID.randomUUID(), LocalDateTime.now().plusMinutes(1));

        final AuthenticationService authenticationServiceToken =
                new AuthenticationService(tokenService);
        final AuthenticationService authenticationServiceUnp =
                new AuthenticationService(userCredentialsService, authenticationServiceToken);

        userCredentialsService.createCredentials("Andrzej", "andy_123");
        final Token grazyna = tokenService.generate("Grazyna");

        final boolean result = authenticationServiceUnp.authenticate("Grazyna", grazyna.getValue().toString());
        System.out.println(result);
    }
}
