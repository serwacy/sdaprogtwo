package pl.sdacademy.prog.chainOfResponsibility;

public interface Authenticator {
    boolean matches (final String username, final String credential);
}
