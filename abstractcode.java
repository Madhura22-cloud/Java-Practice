abstract class Animal2 {
    void sound() {
        System.out.println("Sound coming");
    }

    abstract void sleep(); 
}

class Dog1 extends Animal2 {
    @Override
    void sleep() {
        System.out.println("Dog is sleeping");
    }
}

public class abstractcode {
    public static void main(String[] args) {
        Animal2 c1 = new Dog1();
        c1.sleep();
        c1.sound();
    }
}
