public class fun2 {
    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        int result = add(num1, num2); 
        
        System.out.println("The sum is: " + result);
    }
}
