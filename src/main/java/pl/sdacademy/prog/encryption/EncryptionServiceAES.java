package pl.sdacademy.prog.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class EncryptionServiceAES {

    private static final String AES_ALGORITHM = "AES";
    private static final int AES_KEY_LENGTH_IN_BYTES = 32;

    public void execute (final String sourcePath, final String targetPath,
                         final int mode, final long seed) throws Exception {
        final byte[] keyData = new byte[AES_KEY_LENGTH_IN_BYTES];
        new Random(seed).nextBytes(keyData);

        final SecretKeySpec aesKey = new SecretKeySpec(keyData,AES_ALGORITHM);
        final Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(mode, aesKey);
        final byte[] input = Files.readAllBytes(Paths.get(sourcePath));
        final byte[] output = cipher.doFinal(input);
        Files.write(Paths.get(targetPath), output, StandardOpenOption.CREATE);
    }
}
