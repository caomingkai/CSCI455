import java.util.ArrayList;



public class rackTester{
	public static void main( String[] args ){

		ArrayList test = new ArrayList();
		String testStr = "ccabb";
		// String unique = "abc";
		// int[] mult = {1,2,3};
		Rack myRack = new Rack( testStr );

		test = myRack.getAllSubsets();

		System.out.println(test);
	}
}

