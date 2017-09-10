import java.util.Scanner;
/**

   Read from a list of num from keyboard.
   print it out seperated with a ','

 */
import java.util.Arrays;
public class ReadNum{

	public static void main(String[] args){

		while(true){
			
			System.out.print("Enter a space seperated list of numbers: ");
			Scanner in = new Scanner(System.in);

			String output = "[";
		
			// if(in.hasNextInt()){
			// 	int num1 = in.nextInt();
			// 	output += num1;
			// }
			// int i=0;
			while(in.hasNextInt()){
			// while(i < 3){
				int num=in.nextInt();
				output +=","+num;	
				// i++;	
			}

			output += "]";

			System.out.println(output);
		}
		

	}

}