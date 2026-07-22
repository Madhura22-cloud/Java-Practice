import java.util.Scanner;

public class FindNumber {

    public static void main(String[] args) {
        
        int[] arr = {3, 8, 1, 7, 5, 9, 10, 14, 17, 77, 54, 4};
        

        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a number to search: ");
        int x = scanner.nextInt();

        // Check if the number x is in the array
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                found = true;
                break;
            }
        }

        
        if (found) {
            System.out.println("FOUND");
        } else {
            System.out.println("NOT FOUND");
        }

        
        scanner.close();
    }
}
