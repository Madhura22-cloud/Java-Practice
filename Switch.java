import java.util.Scanner;
public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter a number (1, 2, or 3): ");
        int number = sc.nextInt();

       switch (number) {
            case 1:
                System.out.println("Good Morning");
                break;
            case 2:
                System.out.println("Namaste");
                break;
            case 3:
                System.out.println("Bonjour");
                break;
            default:
                System.out.println("Invalid input");
        }

        sc.close(); 
    }
}
