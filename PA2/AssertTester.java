/**

   Test the ASSERT in Term Class

 */

   import java.util.ArrayList;
   import java.util.Stack;

public class AssertTester{

	public static void main(String[] args){

       ArrayList< Stack<String> > s = new ArrayList< Stack<String> >();
		
        String a = "";
        System.out.println(a+"b");
		Term term_Y = new Term( 2.3 , 5 );
    	Term term_N=  new Term( 2.3 , -2 );

    	while(true){
    		System.out.println( term_Y.toString() );
    	System.out.println( term_N.toString() );
    	}
    			
	}

}
