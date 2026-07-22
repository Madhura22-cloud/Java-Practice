//LAB 6 ASSIGNMENT 1
/*Write a Java program that demonstrates various operations on a 3D
 array:
 1. Initializing the 3D array with random values.
 2. Finding the maximum value in the array.
 3. Calculating the average of all elements.
 4. Displaying the array. */
import java.util.Random;

public class Array3DOperations {
    public static void main(String[] args) {
        int[][][] array = new int[3][3][3]; 
        Random rand = new Random();

        int sum = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        
        System.out.println("3D Array Elements:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = rand.nextInt(100) + 1; 
                    System.out.print(array[i][j][k] + "\t");

                    
                    if (array[i][j][k] > max) {
                        max = array[i][j][k];
                    }

                    
                    sum += array[i][j][k];
                    count++;
                }
                System.out.println(); 
            }
            System.out.println(); 
        }

        double average = (double) sum / count;
        System.out.println("Maximum value in 3D array: " + max);
        System.out.println("Average of all elements: " + average);
    }
}
