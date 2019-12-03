package pl.sdacademy.prog.encryption;

public class EncryptionDemo {
    public static void main(String[] args) throws Exception {
        final EncryptionServiceAES encryptionServiceAES = new EncryptionServiceAES();
        encryptionServiceAES.execute(args[0], args[1], Integer.parseInt(args[2]), Long.parseLong(args[3]));
    }
}
