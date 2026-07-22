class student {
    public String name;
    public int age;

    void print(String name, int age) {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
    }

    public static void main(String[] args) {
        student s = new student();
        s.print("Madhura", 20);
        s.name="Madhura";
        s.age= 20;
    }
}
