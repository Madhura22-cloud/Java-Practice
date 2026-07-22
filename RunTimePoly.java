class Animal {
  void cry() {
    System.out.println("Animal Cry");
  }
}

class Dog extends Animal {
  @Override
  void cry() {
    System.out.println("Dog barks");
  }
}

public class RunTimePoly {
  public static void main(String[] args) {
    Animal d1 = new Dog();  
    d1.cry();               
  }
}
