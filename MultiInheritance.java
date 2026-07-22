interface Animal4{
  public void walk();
}
interface Horse1{
  public void eat();
}
interface Dog2{
  public void sleep();
}
class Habits implements Animal4,Horse1,Dog2 {
  @Override
  public void walk(){
    System.out.println("Animal Walking");
  }
  @Override
  public void eat(){
    System.out.println("Horse Eating");
  }
  @Override
  public void sleep(){
    System.out.println("Dog Sleeping");
  }

}
public class MultiInheritance {
  public static void main(String[] args) {
      Habits h =new Habits();
      h.walk();
      h.eat();
      h.sleep();
  }
  
}
