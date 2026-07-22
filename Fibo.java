public class Fibo {
    public static void main(String[] args) {
       int no=5;
       int a=0;
       int b=1;

       for(int i=0;i<no;i++)
       {
        System.out.println(a);
       int c=a+b;
       a=b;
       b=c;
       }

    }
}


