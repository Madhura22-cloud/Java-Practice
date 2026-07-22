
class Shape{
    void Ignore (){
        System.out.println("shapes");
    }
}


class Traiangle extends Shape{
    void love(){
        System.out.println("3 trsingle  ");
    }
}

class V extends Traiangle {
     void interfare(){
        System.out.println(" squre  ");
     }
}

public class Inheritance {
    public static void main(String[] args) {
        V t1 = new V();
        t1.interfare();
        t1.Ignore();
        t1.love();
        
    }
}
