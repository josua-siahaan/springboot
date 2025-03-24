package juara.coding.day19.security;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESLightEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class TestEncrypt {
    public static void main(String[] args) {
        String key = "ac336195c30113e01000ee4a2ad9716d237b93df855843bb49821c2cf3034977"; // Contoh kunci dalam heksadesimal
        String plaintext = "Hello, World!";

        String encryptedText = performEncrypt(key, plaintext);
        System.out.println("Encrypted: " + encryptedText);
    }

    public static String performEncrypt(String keyText, String plainText) {
        try {
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] ptBytes = plainText.getBytes();
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(true, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
            int oLen = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(Hex.encode(rv));
        } catch (Exception e) {
            return "Error";
        }
    }
}
