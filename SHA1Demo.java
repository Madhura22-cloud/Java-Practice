import java.security.MessageDigest;
import java.util.Scanner;

public class SHA1Demo {

    // Method to compute SHA-1 hash
    public static String toSHA1(String input) {
        try {
            // Create MessageDigest instance for SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Perform hashing
            byte[] hashBytes = md.digest(input.getBytes("UTF-8"));

            // Convert bytes to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append("0");
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message to hash using SHA-1: ");
        String message = sc.nextLine();

        String hashValue = toSHA1(message);
        System.out.println("SHA-1 Hash: " + hashValue);

        sc.close();
    }
}
