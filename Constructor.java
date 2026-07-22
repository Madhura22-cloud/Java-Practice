public class Constructor {
  String name;

  Constructor() {
    System.out.println("Constructor Caller");
  }

  public static void main(String[] args) {
    Constructor c = new Constructor();
    System.out.println("Object created: " + c);
  }
}
