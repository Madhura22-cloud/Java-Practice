import java.util.Scanner;

public class Hello {
	public static void main(String[]args) {
		System.out.println("Hello world");
	    /*For taking values from users*/
	    Scanner sc =new Scanner (System.in);
	    System.out.println("Enter a value:");
	    int age =sc.nextInt();
	    
	    System.out.println("Enter a floating value:");
	    float floatnum =sc.nextFloat();
	    
	    System.out.println("Enter a sentence:");
	    String line =sc.nextLine();
	    
	    System.out.println("Enter a word:");
	    String word =sc.next();
	    
	    
	   //if else loop 
	    if (age >= 18 ) {
	    	System.out.println("Eligible");
	    }
	    	else {
	    		System.out.println("Not eligible");
	    	}
	    
	    //nested if
	    System.out.println("Are you a citizen? (true/false)");
        boolean citizen = sc.nextBoolean();
        if (age >= 18) {
            if (citizen) {
                System.out.println("Can Vote");
        } else {
            System.out.println("Cannot Vote (Not a citizen)");
        }
    } else {
        System.out.println("Cannot Vote (Under 18)");
    }
        
        // Switch Statement
        System.out.println("Enter a number (1-7):");
        int day = sc.nextInt();
        
        	switch (day) {
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            case 7:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Invalid Day");
        }

        sc.close();
     }

}
