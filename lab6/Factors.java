import java.util.Scanner;

/**
   class contains static method to find all factors of n
   plus a test driver for the function
*/
public class Factors {


    /**
       finds all of n's factors
       not including 1 and itself
       pre: n >= 1
    */
    public static void factors (int n) {
	int k = 0;

	while (k < n) {
	    if (n % k == 0) {
		System.out.print(k + " ");
	    }
	}
  
    }


    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	System.out.print("Find factors of what number? ");
	int n = in.nextInt();
	System.out.println("Factors of n are: ");

	factors (n);

	System.out.println();
    }

}
