/*public class ParaConstructor{
  String name;
  int age;
  ParaConstructor(String name){
    this.name = name;
  }

    public ParaConstructor(int age) {
      this.age= age;

    }
  

public static void main(String[] args){
  ParaConstructor c1 = new ParaConstructor("Madhura");
  ParaConstructor c2 = new ParaConstructor(20);
  System.out.println(c1.name);
  System.out.println(c2.age);

}
}
*/
//or
public class ParaConstructor{
  String name;
  int age;
  ParaConstructor(String name, int age){
    this.name = name;
    this.age= age;
  }
  public static void main(String[] args){
  ParaConstructor c1 = new ParaConstructor("Madhura",20);
  System.out.println(c1.name);
  System.out.println(c1.age);

}
}