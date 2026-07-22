
class Employee {
    
    private String name;
    private int age;
    private double salary;

    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age > 18) {
            this.age = age;
        } else {
            System.out.println("Age must be above 18");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive");
        }
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        
        Employee emp = new Employee();

        
        emp.setName("Madhura");
        emp.setAge(20);
        emp.setSalary(50000);

        
        System.out.println("Employee Details:");
        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: ₹" + emp.getSalary());
    }
}
