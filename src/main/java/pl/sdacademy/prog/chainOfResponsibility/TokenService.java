package pl.sdacademy.prog.chainOfResponsibility;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class TokenService implements Authenticator{
    private static final long TOKEN_VALIDITY_IN_MINUTES = 5;

    private final TokenRepository tokenRepository;

    public TokenService (final TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
    public Token generate (final String username) {
        final Token token = Token.builder()
                .name(username)
                .value(UUID.randomUUID())
                .expirationTime(LocalDateTime.now().plusMinutes(TOKEN_VALIDITY_IN_MINUTES))
                .build();
        tokenRepository.add(token);
        return token;
    }
    public void deleteAllForUser (final String username) {
        while (true) {
            final Optional<Token> tokenOptional = tokenRepository.findByUsername(username);
            if (tokenOptional.isPresent()) {
                tokenRepository.delete(tokenOptional.get());
            } else {
                break;
            }
        }
    }
    public void deleteByValue (final String tokenValue) {
        tokenRepository.findAll().stream()
                .filter(token -> token.getValue().toString().equals(tokenValue))
                .findFirst()
                .ifPresent(tokenRepository::delete);
    }
    public Optional<Token> refreshToken (final String username, final String value) {
        final Optional<Token> tokenOptional = tokenRepository.findAll().stream()
                .filter(token -> token.getValue().toString().equals(value) && token.getName().equals(username))
                .findFirst();
        if(tokenOptional.isPresent()){
            tokenRepository.delete(tokenOptional.get());
            if(tokenOptional.get().getExpirationTime().isAfter(LocalDateTime.now())) {
                final Token refreshedToken = new Token(username, UUID.fromString(value),
                        LocalDateTime.now().plusMinutes(TOKEN_VALIDITY_IN_MINUTES));
                tokenRepository.add(refreshedToken);
                return Optional.of(refreshedToken);
            }
        }
        return Optional.empty();
    }
    public boolean matches (final String username, final String tokenValue) {
        return tokenRepository.findAll().stream()
                .anyMatch(token -> matches(username, tokenValue, token));
    }
    private boolean matches (final String username, final String tokenValue, final Token token) {
        return token.getExpirationTime().isAfter(LocalDateTime.now())
                && token.getName().equals(username)
                && token.getValue().toString().equals(tokenValue);
    }
}
