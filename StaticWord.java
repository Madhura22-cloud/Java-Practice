class std {
    String name;
    int age;
    static String ClgName = "Dr. D Y Patil Technical Campus";

    std(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("College: " + ClgName);
        System.out.println(); 
    }
}

public class StaticWord {
    public static void main(String[] args) {
        std s1 = new std("Madhura", 20);
        s1.display();

        std s2 = new std("Avishka", 20);
        s2.display();

        
        std.ClgName = "Nutan";

        std s3 = new std("Madhu", 19);
        s3.display();
    }
}
