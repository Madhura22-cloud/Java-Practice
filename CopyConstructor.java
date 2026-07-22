public class CopyConstructor{
  String name;
  int age;
  CopyConstructor(String name,int age){
    this.name = name;
    this.age = age;
  }

    public CopyConstructor(CopyConstructor c) {
      this.name = c.name;
      this.age = c.age;
    }
  
public static void main(String[] args){
  CopyConstructor c1 = new CopyConstructor("Madhura",20);
  CopyConstructor c2 = new CopyConstructor(c1);
  System.out.println(c2.name);
  System.out.println(c2.age);
  System.out.println(c1.name);
  System.out.println(c1.age);

}
}