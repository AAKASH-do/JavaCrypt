import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class SecureEncryption {

    private static final int AES_KEY_SIZE = 128;
    private static final int GCM_TAG_LENGTH = 128;
    private static final int IV_LENGTH = 12;

    // Generate a new SecretKey for encryption
    public static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(AES_KEY_SIZE);
        return keygen.generateKey();
    }

    // Generate a new random IV (Initialization Vector)
    public static byte[] generateIV() {
        byte[] iv = new byte[IV_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return iv;
    }

    // Encrypt the input string with the given SecretKey and IV
    public static String encrypt(String input, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);
        byte[] encryptedData = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Decrypt the input string with the given SecretKey and IV
    public static String decrypt(String encrypted, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptedData);
    }
}
