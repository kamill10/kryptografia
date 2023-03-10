import java.security.SecureRandom;
public class Key {
    private byte[] keyGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        return key;
    }
    public static byte[] generateSubKey(byte[] masterKey, int round) {
        byte[] subKey = new byte[16];
        byte[] rcon = Rcon(round);

        for (int i = 0; i < 16; i++) {
            if (i < 4) {
                subKey[i] = (byte)(masterKey[i] ^ rcon[i]);
            } else {
                subKey[i] = (byte)(subKey[i - 4] ^ masterKey[i]);
            }
        }
        return subKey;
    }

    private static byte[] Rcon(int round) {
        byte[] rcon = new byte[4];
        rcon[0] = (byte)(1 << round);
        return rcon;
    }
}
