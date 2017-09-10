// Name: Mingkai Cao
// USC loginid: mingkaic
// CS 455 PA2
// Spring 2017


import java.util.ArrayList;


/**
   A polynomial. Polynomials can be added together, evaluated, and
   converted to a string form for printing.
*/
public class Polynomial {

	 /**
		Representation Invariants:
		0. termArray[0]{coeff=1,expon=9} -> termArray[1]{1,8} -> termArray[1]{1,7} -> termArray[1]{1,6} ...
		1. items in 'termArray' are in strictly descending order, by exponent value.
		2. the value of 'expon' is larger than 0.
		3. the value of 'coeff' cannot be 0.0,
		4. --Print Invariant--
		4.1 when coeff==0.0 , don't print out this poly term
		4.2 when coeff==0.0 is the case for every term in poly, print '0.0'
		4.3 when coeff==1.0 , just print out the exponent part of the term
		4.4 when expon==0   , just print out the coeff part of the term
		4.5 when expon==1   , print out coeff with 'x' for the term
		@param termArray is an ArrayList with Term type elements inside it, as described as above
	*/
    private ArrayList<Term> termArray;
   


    /**
       Creates the zeor polynomial
    */
    public Polynomial() {
    	
        this( new Term() );   			 // new Term : {0.0, 0}
    	assert this.isValidPolynomial();
    }


    /**
       Creates polynomial with single term given
     */
    public Polynomial(Term term) {

      termArray = new ArrayList<Term>();
      if(term.getCoeff() != 0){	 		// don't accept term with coeff==0
    	  termArray.add(term); 
      }
  	  assert this.isValidPolynomial();
    }


    /**
       Returns the Polynomial that is the sum of this polynomial and b
       (neither poly is modified)
     */
    public Polynomial add(Polynomial b) {

      Polynomial sum = new Polynomial();
      int sizeA = this.termArray.size();
      int sizeB = b.termArray.size();
      int i = 0 , j = 0;  // used to loop through this.termArray
   
      while( i < sizeA && j < sizeB ){	     	// both polynomial have terms to be compared
    	  
    	  Term termA = this.termArray.get(i);   // ith term, denoted as termA, in polynomial 'this'
          Term termB =    b.termArray.get(j);	// jth term, denoted as termB, in polynomial 'b'
          int exponA = this.termArray.get(i).getExpon(); // exponent for the ith term: termA
          int exponB =    b.termArray.get(j).getExpon(); // exponent for the jth term: termB

          if(exponA > exponB){					// when exponA > exponB, add termA first
            sum.termArray.add( termA );
            i++;
          }else if( exponA < exponB ){			// when exponA < exponB, add termB first
            sum.termArray.add( termB );
            j++;
          }else{								// when exponA == exponB, add BOTH termA and termB
            double coeffSum = termA.getCoeff() + termB.getCoeff();
            if(coeffSum != 0){					// if coeffSum == 0, this item won't be added up 
            	Term termSum = new Term(coeffSum, exponA);
                sum.termArray.add( termSum );
            }
            i++;
            j++;
          }
      }
      
      for( ; i < sizeA; i++){
    	  sum.termArray.add( this.termArray.get(i) );
      }
      
      for( ; j < sizeB; j++){
    	  sum.termArray.add( b.termArray.get(j) );
      }
      
  	  assert this.isValidPolynomial();
  	  assert b.isValidPolynomial();
  	  assert sum.isValidPolynomial();
      return sum;  
    }


    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {

      double sumCur = 0.0;			  				 // store summation value for terms in a polynomial
      int termNum = termArray.size();

      for(int i = termNum -1 ; i >= 0; i--){
    	  
        double termVal = 1.0;         				 // store multiplying value for a term
        double coeff = termArray.get(i).getCoeff();
        int expon = termArray.get(i).getExpon();

        for(int j = 0; j < expon; j++){
          termVal *= x;
        }
        termVal *= coeff;
        sumCur += termVal;
      }
      assert this.isValidPolynomial();
	  return sumCur; 
    }


    /**
       Return a String version of the polynomial with the 
       following format, shown by example:
       zero poly:   "0.0"
       1-term poly: "3.2x^2"
       4-term poly: "3.0x^5 + -x^2 + x + -7.9"

       Polynomial is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
    */
    public String toFormattedString() {
    	
      String result = "";
      int termNum = termArray.size();
      if( termNum == 0) {									// zero-polynomial case
    	  result = "0.0";
      }else{												// non-zero polynomial case
    	  result = oneTerm_toFormattedString( termArray, 0 );			    // deal with 1st term
          for(int i = 1; i < termNum; i++){ 								// deal with the remaining terms
        	  if( oneTerm_toFormattedString( termArray, i).length() != 0 ){ // only deal with non-zeor term
        		  if(result.length() != 0 ){								// non-zero term, PLUS all terms before current term are non-zero can have '+' preceding it
        			  result += " + "  + oneTerm_toFormattedString( termArray, i);
        		  }else{
        			  result +=  oneTerm_toFormattedString( termArray, i);  // if terms before the current term are zero-term, no '+' preceding it
        		  }  
        	  }
          }
      }
      assert this.isValidPolynomial();
      return result;       
    }


    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPolynomial() {
    	
    	boolean validOrNot = false;    // initially assume poly is NOT valid.
    	int termNum = termArray.size();	
   		
   		if(termNum == 0){								// zero-polynomial case is valid
   			validOrNot =true; 
   		}else if(termNum == 1){							// one-term polynomial case
   			Term term = termArray.get(0);	 	        // get the 1st term
   			double coeff = term.getCoeff();
   			int expon = term.getExpon();
       		if( coeff!=0.0 && expon >= 0){
       			validOrNot =true; 
       		}
    	}else{ 											 // termNum >= 2 case
   			for( int i = 0; i < termNum-1 ; i++){ 	 
   				Term termFormer = termArray.get(i);		 // get the former term
   				Term termLatter = termArray.get(i+1);	 // get the latter term
   				double coeffFormer = termFormer.getCoeff();
   				double coeffLatter = termLatter.getCoeff();
   				int exponFormer = termFormer.getExpon();
   				int exponLatter = termLatter.getExpon();
   														// check invariant_1 , invariant_1 , invariant_3 below
           		if((coeffFormer !=0) && (coeffLatter !=0) && (exponFormer >=0) && (exponLatter >=0) && (exponFormer > exponLatter) ){ 
           			validOrNot = true; }
        	}
    	}
   		return validOrNot;    
    }
   
    
    /**
       Return a String version of one term in polynomial without preceding '+', like:
       zero term: ""
       one term	: 3.2x^2
       one term	: -x^2 
       @para termArray  is  representation of its polynomial
       @para index  is the term with such a index from polynomial
    */
    private String oneTerm_toFormattedString( ArrayList<Term> termArray, int index ){
    	
      double coeff = termArray.get(index).getCoeff();
  	  int expon = termArray.get(index).getExpon();
  	  String result ="";
  	  if(coeff != 0.0){ 	// only deal with case: coeff!=0 
  		if(expon == 0){		
    		  if( coeff == 1.0 ){
    			  result += "1.0";		//  when expon=0 && coeff=1.0 , print "1.0"
    		  }else if( coeff == -1.0 ){
    			  result += "-1.0";		//  when expon=0 && coeff=-1.0 , print "-1.0"
    		  }else{
    			  result += coeff;		//  when expon=0 && coeff !=1.0 && coeff !=-1.0, print coeff value
    		  }
    	  }else if(expon == 1){
    		  if( coeff == 1.0 ){
    			  result += "x";
    		  }else if( coeff == -1.0 ){
    			  result += "-x";
    		  }else{
    			  result += coeff + "x";
    		  }
    	  }else{
    		  if( coeff == 1.0 ){
    			  result += "x^" + expon;
    		  }else if( coeff == -1.0 ){
    			  result += "-x^" + expon;
    		  }else{
    			  result += coeff + "x^" + expon;
    		  }
    	  }
	  }
  	  return result;
    }
    
    
    /**
    	Returns polynomial representation with coeff-expon pairs, like: [  (6.0  , 3)  (2.0  , 2)  (1.0  , 1)  ]
    */   
    public String toString(){
    	
    	int arrayLength = termArray.size();
        String outcome ="[ ";
        for(int i = 0; i < arrayLength; i++){
          outcome += " (" + termArray.get(i).getCoeff() + "  , " +termArray.get(i).getExpon() + ") ";
        }
        outcome += " ]";
        
        return outcome;
    }

    
}
