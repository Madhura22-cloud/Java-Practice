
public class StringDemo {
    public static void main(String[] args) {
        
        String FName = "Madhura";
        String LName = "Pawar";
        String FullName = FName.concat(LName);// it add two string 
         // System.out.println("Full Name: " + FullName);
         for (int i = 0; i < FullName.length(); i++) {
            System.out.println( "Index " + i + ": "+FullName.charAt(i));
        }
        //  System.out.println(FName.equals(LName));
        System.out.println((String) FName.substring(0,2)); // its return String -1 length
    }
}
