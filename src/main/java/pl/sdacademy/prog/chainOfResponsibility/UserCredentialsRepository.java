package pl.sdacademy.prog.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCredentialsRepository {
    private List<UserCredentials> credentialsList = new ArrayList<>();

    public Optional<UserCredentials> findByUsername (final String username) {
        return credentialsList.stream()
                .filter(userCredentials -> userCredentials.getUsername().equals(username))
                .findFirst();
    }



    public void add (final UserCredentials userCredentials){
        credentialsList.add(userCredentials);
    }
    public void remove (final String username) {
        findByUsername(username)
                .ifPresent(userCredentials -> credentialsList.remove(userCredentials));
    }
    public List<UserCredentials> getAll() {
        return credentialsList;
    }
}
