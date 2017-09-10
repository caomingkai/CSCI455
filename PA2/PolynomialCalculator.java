// Name: Mingkai Cao
// USC loginid: mingkaic
// CS 455 PA2
// Spring 2017


import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

/**
	A polynomialCalculator is a user interface,an interactive program that 
	lets users build and do computations on several Polynomial objects.
	
*/
public class PolynomialCalculator{

	/**
		Representation Invariants:
		1. only 10 (index:0~9) polynomials can be accessed
		
		Commands Options:
		1. create 0  : Create the 1st polynomial");
		2. print 1   : Print out the 2nd polynomial");
		3. add 2 1 0 : The 3rd polynomial is the sum of 1st and 2nd polynomial");
		4. eval 5    : Calculate the 6th polynomial");
		5. help      : Command description");
		6. quit      : Quit the current program");
	 */
	
	public static void main(String[] args){
		
		Polynomial[] polyArray = new Polynomial[10];
		for(int i = 0; i< 10; i++){			// each Polynomial is initialized as a zero-polynomial
			polyArray[i] = new Polynomial();
		}
		
		boolean flag = true;
		while( flag ){
			
			System.out.print("cmd> ");
			Scanner in = new Scanner( System.in );
			
			String command = "";
			if(in.hasNext()){			// waiting for users' commands
				command = in.next();
			}
			
			if(command.equalsIgnoreCase( "create" ) ){		// create poly
				create( in , polyArray );
			}else if(command.equalsIgnoreCase( "print" ) ){ // print poly
				print( in , polyArray );
			}else if(command.equalsIgnoreCase( "add" ) ){ 	// add  poly
				add( in , polyArray );
			}else if(command.equalsIgnoreCase( "eval" ) ){	// evaluate poly
				eval( in , polyArray  );
			}else if(command.equalsIgnoreCase( "help" ) ){	// help info
				help();
			}else if(command.equalsIgnoreCase( "quit" ) ){	// quit program
				flag = false;
			}else{											// illegal command
				System.out.println("ERROR: Illegal command.  Type 'help' for command options.");
			}
		}
	}


	/**
		create a specific polynomial with the given the index from the following input.
		@para in 	: waiting for input of index
		@para polyArray : polyArray already created
	*/
	private static void create( Scanner in , Polynomial[] polyArray ){

		int index = oneIndexInput( in ); // wait for the input of polynomial-array index
		if(index == -1){			     // if input is invalid, return value is '-1', return to the while loop
			return;
		}
		System.out.println("Enter a space-separated sequence of coeff-power pairs terminated by <nl>");
		//create a new Scanner to read a int value, using nextLine() to return when return key is pressed
		Scanner in2 = new Scanner(System.in);
		String termString = in2.nextLine();
		Scanner in3 = new Scanner(termString);
		Polynomial polySum = new Polynomial();
		boolean negativeExponent = false;  // indicate negative exponent or not. Default is NON-negative.
		
		while( in3.hasNextDouble() ){
			double coeff = in3.nextDouble();
			if(in3.hasNextInt() ){		   // only with a int-type Expon can we compose a term
				int expon = in3.nextInt() ;
				if( expon < 0){			   // when expon<0 , use the absolute value
					negativeExponent = true;
					expon = Math.abs( expon );
				}
				Term term = new Term( coeff, expon );
				Polynomial polyCur = new Polynomial( term );
				polySum = polySum.add( polyCur );
			}else{	 					  // if there is no int-type Expon, trim it and give out WARNING INFO
				System.out.println("WARNING: Missing the last exponent (i.e., odd number of values).");
			}
		}
		if(negativeExponent){
			System.out.println("WARNING: Negative exponent.");
		}
		polyArray[index] = polySum;	
	}


	/**
		Return a String version of the polynomial that's close to the usual format we use to denote polynomials
		@para in 	: waiting for input of index
		@para polyArray : polyArray already created
	*/
	private static void print( Scanner in , Polynomial[] polyArray ){
		int index = oneIndexInput( in );
		if(index == -1){
			return;
		}
		System.out.println( polyArray[index].toFormattedString() );
	}


	/**
		polynomial summation. eg. 'add 2 1 0' : sum the polynomial[1] and polynomial[0], and give the value the polynomial[2] 
		@para in 	: waiting for input of index
		@para polyArray : polyArray already created
	*/
	private static void add( Scanner in , Polynomial[] polyArray ){
		
		ArrayList<Integer> indexArray = new ArrayList<Integer>();// store index input from user(no more than 10 polynomial)
		String indexString = in.nextLine();
		Scanner in2 = new Scanner(indexString);
		
		while( in2.hasNextInt() ){			// read all indices to indexArray
			int index = oneIndexInput( in2 );
			if( index == -1){ return; }
			indexArray.add( index);
		}
		int polyNum = indexArray.size();
		Polynomial sum = new Polynomial();  // used for store sum result 
		if(polyNum >= 2){
			for(int i = 1; i < polyNum; i++){// add up the 2nd til the last Polynomial
				sum = sum.add( polyArray[ indexArray.get(i) ] ) ;
			}
			int addedIndex = indexArray.get(0);
			polyArray[addedIndex] = sum;     // give the value to the polynomial with index from the first item of indexArray
		}
	}


	/**
		calculate the value of specific polynomial with given index
		@para in 	: waiting for input of index
		@para polyArray : polyArray already created
	*/
	private static void eval( Scanner in , Polynomial[] polyArray ){
		
		int index = oneIndexInput( in );
		if(index == -1){
			return;
		}
		//create a new Scanner to read a float value, using nextLine() to return when return key is pressed
		System.out.print("Enter a floating point value for x: ");
		Scanner in4 = new Scanner(System.in);
		String xString = in4.nextLine();
		Scanner in5 = new Scanner(xString);
		
		if( in5.hasNextDouble() ){
			double x = in5.nextDouble();
			double result = polyArray[index].eval(x);
			System.out.println(result);
		}else{
			System.out.println("ERROR: 'x' has to be a floating point type. ");
		}

	}


	/**
		 intro message that directs users to a help command option
	*/
	private static void help(){
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Here are the command descriptions:");
		System.out.println("1. create 0  : Create the 1st polynomial");
		System.out.println("2. print 1   : Print out the 2nd polynomial");
		System.out.println("3. add 2 1 0 : The 3rd polynomial is the sum of 1st and 2nd polynomial");
		System.out.println("4. eval 5    : Calculate the 6th polynomial");
		System.out.println("5. help      : Command description");
		System.out.println("6. quit      : Quit the current program");
		System.out.println("------------------------------------------------------------------------");
		
	}

	/**
		read from keyboard for index input
		@para in : waiting for input of index
	*/
	private static int oneIndexInput( Scanner in ){

		int index = -1;					// illegal type(string) or value(<0 or >9)

		if( in.hasNextInt() ){			// legal type
			index = in.nextInt();
			if(  index < 0 || index > 9){
				System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
				index = -1;;			// illegal value
			}
		}else{							// illegal type
			System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
		}
		return index;
	}

}


