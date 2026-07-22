// LAB 2 ASSSIGNMENT 2
/*● Create a Java Bean Class Student.
 ● Addthree attributes
 ○ private String name;
 ○ private int age;
 ○ private String department;
 ● Addaconstructor that takes all three attributes as parameters.
 ● Addsetter and getter methods
 ● Compile the program */
public class TestStudent {
    // Private attributes
    private String name;
    private int age;
    private String department;

    // Constructor to initialize all attributes
    public TestStudent(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Setter for department
    public void setDepartment(String department) {
        this.department = department;
    }

    public static void main(String[] args) {
        // Create Student object
        TestStudent student = new TestStudent
        ("Madhura", 20, "Computer Science");

        // Display details using getters
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Department: " + student.getDepartment());

        // Modify values using setters
        student.setAge(21);
        student.setDepartment("Information Technology");

        // Display updated details
        System.out.println("\nUpdated Student Info:");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Department: " + student.getDepartment());
    }
}
