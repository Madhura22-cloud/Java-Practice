import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  

        System.out.println("Enter your name : ");
        String name  = sc.nextLine(); 

        System.out.println("Enter your age: ");
         int age = sc.nextInt();

           System.out.println(" mHello "  + name +  " your are" + age + " year old ");  
           sc.close();
    }
}
