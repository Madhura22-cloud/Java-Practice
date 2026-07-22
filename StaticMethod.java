class Demo {
  static  void printinfo(){
        System.out.println("Hello");
    }
}


public class StaticMethod {
    public static void main(String[] args) {
        Demo.printinfo();
    }
}