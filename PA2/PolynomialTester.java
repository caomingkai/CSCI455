/**

   Test the Polynomial Class

 */
public class PolynomialTester{

	public static void main(String[] args){

		Polynomial emptyP = new Polynomial();
		System.out.println(emptyP);

		Term first = new Term(0,0);
		Polynomial termP1 = new Polynomial(first);
		System.out.println("---------------------");
		System.out.println(termP1);
		System.out.println(termP1.toFormattedString() );
		System.out.println("---------------------");
		Term second = new Term(1,1);
		Polynomial termP2 = new Polynomial(second);
		System.out.println(termP2);

		Term third = new Term(2,2);
		Polynomial termP3 = new Polynomial(third);
		System.out.println(termP3);

		Term fourth = new Term(3,3);
		Polynomial termP4 = new Polynomial(fourth);
		System.out.println(termP4);
		
		Term fifth = new Term(-3,3);
		Polynomial termP5 = new Polynomial(fifth);
		System.out.println(termP5);
		
		Polynomial twotermP = termP1.add(termP2);
		System.out.println(twotermP);

		// Polynomial twotermP = termP1.add(termP2);
		// twotermP.printResult();

		Polynomial thirdtermP = twotermP.add(termP3);
		System.out.println(thirdtermP);

		Polynomial fourthtermP = thirdtermP.add(termP4);
		System.out.println(fourthtermP);

		Polynomial fifthtermP = fourthtermP.add(termP4);
		System.out.println(fifthtermP);

		//--------------eval()------------------
		System.out.println("0: " + termP1.eval(-1));
		System.out.println("1: " + termP2.eval(-1));
		System.out.println("2: " + termP3.eval(-1));
		System.out.println("8: " + termP3.eval(-2));

		System.out.println("6: " + fourthtermP.eval(1));
		System.out.println("34: " + fourthtermP.eval(2));
		System.out.println("-66: " + fourthtermP.eval(-3));
		
		//--------------toFormattedString()------------------
		System.out.println( termP1.toFormattedString() );
		System.out.println( termP2.toFormattedString() );
		System.out.println( termP3.toFormattedString() );
		System.out.println( termP4.toFormattedString() );
		System.out.println( termP5.toFormattedString() );
		System.out.println("---------------------");
		termP5 = termP5.add(termP4);
		System.out.println( termP5.toFormattedString() );
		System.out.println("---------------------");
		System.out.println( twotermP.toFormattedString() );
		System.out.println( thirdtermP.toFormattedString() );
		System.out.println( fourthtermP.toFormattedString() );
		System.out.println(fifthtermP.toFormattedString() );
		
		//--------------isValidPolynomial()------------------

		Term one = new Term(0,0);
		Polynomial P1 = new Polynomial(one);
		System.out.println(P1);

		Term two = new Term(0,0);
		Polynomial P2 = new Polynomial(two);
		System.out.println(P2);
		
		//--------------toString()----------------------------
		System.out.println(fifthtermP);
		System.out.println(fourthtermP);
		System.out.println(thirdtermP);
		
		
	}

}