public class StaticClass {
    static final int VALUE;

    static {
        VALUE = 100;
        System.out.println("Static block: value set to " + VALUE);
    }

    public static void main(String[] args) {
        System.out.println("Main: value is " + VALUE);
    }
}

