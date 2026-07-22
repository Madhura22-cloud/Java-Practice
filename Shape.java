class Shape3 {
    void area() {  
        System.out.println("Area");
    }
}

class Triangle extends Shape3 {
    
}

public class Shape{
    public static void main(String[] args) {
          
        Triangle t1 = new Triangle(); 
        t1.area();
    }
}