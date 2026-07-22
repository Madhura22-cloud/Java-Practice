//LAB 3
/*Write a Java program that uses a method to calculate the area of a rectangle and
 compare them using Relational Operator
 Steps:
 ● Create a class Rectangle.
 ● TheRectangle class should have two attributes length and width of type int.
 ● Create a constructor that accepts length and width as parameters.
 ● Areashould be calculated as length*area.
 ● Instantiate two Rectangle classes with random values.
 ● Comparethe areas of the two rectangles using the Relational Operator.
 ● If the first one is bigger than the second one, print “Rectangle1 > Rectangle2”.
 ● If the first one is smaller print “Rectangle1 < Rectangle2”.
 ● Otherwise print “They are equal” */
public class Rectangle {
    // Attributes
    int length;
    int width;

    // Constructor
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate area
    public int calculateArea() {
        return length * width;
    }

    // Main method
    public static void main(String[] args) {
        // Create two rectangle objects with sample values
        Rectangle rectangle1 = new Rectangle(10, 5); // Area = 50
        Rectangle rectangle2 = new Rectangle(8, 7);  // Area = 56

        // Calculate areas
        int area1 = rectangle1.calculateArea();
        int area2 = rectangle2.calculateArea();

        // Display areas
        System.out.println("Area of Rectangle1: " + area1);
        System.out.println("Area of Rectangle2: " + area2);

        // Compare using relational operators
        if (area1 > area2) {
            System.out.println("Rectangle1 > Rectangle2");
        } else if (area1 < area2) {
            System.out.println("Rectangle1 < Rectangle2");
        } else {
            System.out.println("They are equal");
        }
    }
}
