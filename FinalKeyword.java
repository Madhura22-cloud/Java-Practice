public class FinalKeyword {
  final void speed(){
    System.out.println("200");

  }
  public static void main(String[] args) {
      final int speed =120;
      // speed = 200;
      System.out.println("The speed is: " + speed);
      FinalKeyword f = new FinalKeyword();
      f.speed();
      //override o = new override();
      //o.speed();
  }
  
}
/*class override extends FinalKeyword{
  final void speed(){
    System.out.println("4500");
  }
}
  */
