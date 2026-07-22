import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESDemo {

    // Method to perform encryption
    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // encode to Base64
    }

    // Method to perform decryption
    public static String decrypt(String cipherText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }

    // Main method
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Generate DES key
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGen.generateKey();

            // Input message
            System.out.print("Enter message to encrypt: ");
            String message = sc.nextLine();

            // Encryption
            String cipherText = encrypt(message, secretKey);
            System.out.println("Encrypted Text: " + cipherText);

            // Decryption
            String decryptedText = decrypt(cipherText, secretKey);
            System.out.println("Decrypted Text: " + decryptedText);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

