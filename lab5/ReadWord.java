
import java.util.Scanner;
/**

   Read from a list of num from keyboard.
   print it out seperated with a ','

 */

public class ReadWord{

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		in.useDelimiter("[^A-Za-z]+");
		
		while (in.hasNext())
		{
			String input = in.next();

			System.out.println(input);
		}

	}
}

