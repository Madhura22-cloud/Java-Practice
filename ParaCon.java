public class ParaCon {
    String name;
    int age;

  
    ParaCon(String n, int a) {
        name = n;
        age = a;
    }

    void printInfo() {
        System.out.println(  name);
        System.out.println( age);
    }

    public static void main(String[] args) {
     ParaCon p1 = new ParaCon("Manthan", 30);
     ParaCon p2 = new ParaCon("Madhura", 1);
        p1.printInfo();
        p2.printInfo();

    
    }
}
