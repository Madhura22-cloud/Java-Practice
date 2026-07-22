// LAB 4 ASSIGNMENT 3
/* Write a program to count and print the total number of odd and even
 numbers from user inputs. Program will ask for user inputs in a loop. Loop
 will terminate if-1 is entered as input */
import java.util.Scanner;

public class CountOddEven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int evenCount = 0;
        int oddCount = 0;
        int number;

        while (true) {
            System.out.print("Enter a number (-1 to stop): ");
            number = sc.nextInt();

            if (number == -1) {
                break;
            }

            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Total Even Numbers: " + evenCount);
        System.out.println("Total Odd Numbers: " + oddCount);
    }
}

