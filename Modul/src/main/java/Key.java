import java.security.SecureRandom;
public class Key {
    private byte[] keyGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        return key;
    }
}
