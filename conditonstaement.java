import java.util.Scanner;
public class conditonstaement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter a number (1, 2, or 3): ");
        int number = sc.nextInt();

        if (number == 1) {
            System.out.println("Good Morning");
        } 

        else if (number == 2) {
            System.out.println("Namaste");
        } 

        else if (number == 3) {
            System.out.println("Bonjour");
        } 

        else {
            System.out.println("Invalid input");
        }

        sc.close(); 
    }
}
