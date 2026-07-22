interface Animal3{
  public void walk();
}
class Horse implements Animal3{
  @Override
  public void walk(){
    System.out.println("Horse Running");
  }
}
public class InterfaceCode { 
  public static void main(String[] args) {
      Horse h1 = new Horse(); 
      h1.walk();

  }
}