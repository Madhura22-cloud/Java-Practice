public class PalindromeNumber {
    public static void main(String[] args) {
        int num = 121;          
        int temp = num;         
        int reverse = 0;

        while (num != 0) {
            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;
        }

        if (temp == reverse) {
            System.out.println(temp + " is a Palindrome.");
        } else {
            System.out.println(temp + " is NOT a Palindrome.");
        }
    }
}
