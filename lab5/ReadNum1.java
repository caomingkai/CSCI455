import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**

   Read from a list of num from keyboard.
   print it out seperated with a ','

 */
import java.util.Arrays;
public class ReadNum1{

	public static void main(String[] args){

		while(true){
			
			System.out.print("Enter a space seperated list of numbers: ");

			Scanner in = new Scanner(System.in);
			String line = in.nextLine();
			Scanner lineScanner = new Scanner(line);

			ArrayList<Integer> num = new ArrayList<Integer>();
			while(lineScanner.hasNextInt()){

				num.add( lineScanner.nextInt() );
			}

			System.out.println(num);
		}
		

	}

}