package pl.sdacademy.prog.chainOfResponsibility;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class ExpiredTokenCleaningTask implements Runnable {
    private static final Long ONE_MINUTE_IN_MILLIS = 60000L;

    private final TokenRepository tokenRepository;

    public ExpiredTokenCleaningTask(final TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(ONE_MINUTE_IN_MILLIS);
            } catch (final InterruptedException exp) {
                log.info("Token cleaning thread exiting");
                log.debug("", exp);
                break; // ?
            }
            removeExpiredTokens();
        }
    }
    private synchronized void removeExpiredTokens() {
        tokenRepository.findAll().stream()
                .filter(token -> token.getExpirationTime().isBefore(LocalDateTime.now()))
                .forEach(tokenRepository::delete);
    }
}
