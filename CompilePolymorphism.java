class CompilePolymorphism{
  String name;
  int age;
  int id;
  String email;

  void printinfo(String name,int age,int id,String email)
  {
    this.name=name;
    this.age=age;
    this.id=id;
    this.email=email;
    System.out.println("Name:"+name);
    System.out.println("Age :"+age);
    System.out.println("Id:"+id);
    System.out.println("Email:"+email);

  }
  void printinfo(String name,int age,int id)
  {
    this.name=name;
    this.age=age;
    this.id=id;
    System.out.println("Name:"+name);
    System.out.println("Age :"+age);
    System.out.println("Id:"+id);
    
  }
  void printinfo(String name,int age)
  {
    this.name=name;
    this.age=age; 
    System.out.println("Name:"+name);
    System.out.println("Age :"+age);
   
   
  }
  public static void main(String[] args) {
      CompilePolymorphism p1 = new CompilePolymorphism();
      //p1.name="Madhura";
      //p1.age=20;
      //p1.id=25114;
      //p1.email="abc@gmail.com";
      p1.printinfo("Madhura",20,25114,"abc@gmail.com");
      p1.printinfo("Madhura",20,25114);
      p1.printinfo("Madhura",20);
  }
}