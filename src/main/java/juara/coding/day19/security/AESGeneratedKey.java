package juara.coding.day19.security;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Security;


public class AESGeneratedKey {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        try {
//            Inisialisasi Kunci Generator AES dengan Bouncy Castle
            KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");

//            Inisialisasi panjang kunci generatornya
            keyGen.init(256);

//            Generate kunci AES
            SecretKey secretKey = keyGen.generateKey();

//            Tampilkan kunci AES dalam bentuk heksadesimal
            System.out.println("Encode : " + secretKey.getEncoded());
            System.out.println("AES Key: " + bytesToHex(secretKey.getEncoded()));
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getKey() {
        SecretKey aesKey = null;
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");
            // Atur panjang kunci (misalnya: 128, 192, atau 256 bit)
            keyGen.init(128);
            // Generate kunci AES
            aesKey = keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytesToHex(aesKey.getEncoded());
    }

    // Helper method untuk mengubah byte array menjadi string heksadesimal
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}