//LAB 5 ASSIGNMENT 2
/*Create a class called Student.
 Inside the Student class, implement the following instance variables
 (fields):
 ● String name
 ● int age
 ● String department
 Implement the following constructors in the Student class:
 ● Adefault constructor that initializes the name to "Unknown",
 age to 20, and department to "Unassigned".
 ● Aconstructor that takes two parameters: name and age, and
 initializes the department to "IT".
 ● Aconstructor that takes three parameters: name, age, and
 department.
 In the Main class, create instances of the Student class using each
 constructor */
public class Student2 {
    String name;
    int age;
    String department;

    public Student2() {
        this.name = "Unknown";
        this.age = 20;
        this.department = "Unassigned";
    }

   
    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
        this.department = "IT";
    }


    public Student2(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

   
    public void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Department: " + department);
    }

  
    public static void main(String[] args) {
     
        Student2 student1 = new Student2();
        student1.printDetails();

        Student2 student2 = new Student2("Madhura", 20);
        student2.printDetails();

        
        Student2 student3 = new Student2("Avishka", 20, "Computer Science");
        student3.printDetails();
    }
}
