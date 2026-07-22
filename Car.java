// LAB 2 ASSIGNMENT 1
/* Write a Java program named Car
 ● TheCarclass should have the following attributes: make (String), model
 (String) , year (short) , and price(int) .
 ● Thecarclass should have a constructor that takes all the attributes.
 ● Addamainmethod to instantiate car objects.
 ● Theprogram should allow the user to create and display objects of each
 Car Class */
import java.util.Scanner;

public class Car {
    // Attributes
    String make;
    String model;
    short year;
    int price;

    // Constructor
    public Car(String make, String model, short year, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make  : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year  : " + year);
        System.out.println("Price : ₹" + price);
        System.out.println("------------------------");
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many cars to create
        System.out.print("Enter number of cars to create: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Car[] cars = new Car[count];

        // Input details for each car
        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Car #" + (i + 1));
            System.out.print("Make: ");
            String make = scanner.nextLine();

            System.out.print("Model: ");
            String model = scanner.nextLine();

            System.out.print("Year: ");
            short year = scanner.nextShort();

            System.out.print("Price: ");
            int price = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Create car object
            cars[i] = new Car(make, model, year, price);
        }

        // Display all cars
        System.out.println("\nDisplaying All Cars:");
        for (Car car : cars) {
            car.displayDetails();
        }

        scanner.close();
    }
}
