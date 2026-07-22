// public class ArrayExample {
//     public static void main(String[] args) {
//         int[] arr = new int[10];

//         arr[0] = 10;
//         arr[1] = 20;
//         arr[2] = 30;
//         arr[3] = 40;
//         arr[4] = 50;
//         arr[5] = 10;
//         arr[6] = 20;
//         arr[7] = 30;
//         arr[8] = 40;
//         arr[9] = 50;

//          System.out.println("Array elements:");
//         for (int i = 0; i <10; i++) {
//             System.out.println(arr[i]);
//         }
//     }
// }

        
     import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
         int[] arr = new int[size]; 


        System.out.println("Enter 10 numbers:");

        
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();  
        }

        System.out.println("Array elements:");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

        sc.close(); 
    }
}
