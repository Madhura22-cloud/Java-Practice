//LAB 4 ASSIGNMENT 2
/* Write a program to find out all the armstrong numbers within a given
 range using a method named printArmstrongNumber( int start, int
 end) by taking input from the user. The program should print the
 Armstrong number in a given range starting from “start” and ending
 with “end”.
 Armstrong Number Example: 153 13+53+33=153 (Number which is equal
 to the sum of the cubes of its digits)
 Note: input should be taken from the keyboard. Use a loop to calculate the
 Armstrong number from “start” to “end”. Also use loops to calculate the
 cube of a number. Do not use the Math.pow() function */
import java.util.Scanner;

public class ArmstrongRange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter start of range: ");
        int start = sc.nextInt();

        System.out.print("Enter end of range: ");
        int end = sc.nextInt();

        // Calling method to print Armstrong numbers
        printArmstrongNumber(start, end);
    }

    // Method to check and print Armstrong numbers
    static void printArmstrongNumber(int start, int end) {
        System.out.println("Armstrong numbers between " + start + " and " + end + " are:");

        for (int num = start; num <= end; num++) {
            int originalNum = num;
            int sum = 0;

            int temp = num;
            while (temp > 0) {
                int digit = temp % 10;

                // Calculate cube of digit using loop
                int cube = 1;
                for (int i = 0; i < 3; i++) {
                    cube *= digit;
                }

                sum += cube;
                temp /= 10;
            }

            if (sum == originalNum) {
                System.out.println(originalNum);
            }
        }
    }
}
