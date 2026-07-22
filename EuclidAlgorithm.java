import java.util.Scanner;

public class EuclidAlgorithm {

    // Euclid's Algorithm for GCD
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Extended Euclidean Algorithm
    // Returns array: [gcd, x, y] such that a*x + b*y = gcd(a,b)
    static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        } else {
            int[] vals = extendedGCD(b, a % b);
            int gcd = vals[0];
            int x1 = vals[2];
            int y1 = vals[1] - (a / b) * vals[2];
            return new int[]{gcd, x1, y1};
        }
    }

    // Function to find multiplicative inverse of 'a' mod 'm'
    static int multiplicativeInverse(int a, int m) {
        int[] result = extendedGCD(a, m);
        int gcd = result[0];
        int x = result[1];

        if (gcd != 1) {
            // Inverse doesn't exist if a and m are not coprime
            System.out.println("Multiplicative inverse does not exist.");
            return -1;
        } else {
            // Ensure positive value
            return (x % m + m) % m;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for GCD
        System.out.print("Enter first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b = sc.nextInt();

        int gcdValue = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " = " + gcdValue);

        // Input for multiplicative inverse
        System.out.print("\nEnter integer to find inverse: ");
        int num = sc.nextInt();
        System.out.print("Enter modulo value: ");
        int mod = sc.nextInt();

        int inverse = multiplicativeInverse(num, mod);
        if (inverse != -1) {
            System.out.println("Multiplicative Inverse of " + num + " mod " + mod + " = " + inverse);
        }

        sc.close();
    }
}
