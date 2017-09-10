
import java.util.Arrays;
import java.lang.Integer;
/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
public class Nums {

  private final static int DEFAULT_CAPACITY = 3;
  private int[] numsArray;
  private int numOfNums;

    /**
       Create an empty sequence of nums.
     */
    public Nums () {
      numsArray = new int[DEFAULT_CAPACITY];
      numOfNums = 0;
    }

    /**
       Add a value to the end of the sequence.
     */
    public void add(int value) {

      if( numOfNums == numsArray.length ){// no capacity left, has to double the capacity
        growCapcity();
      }
      numsArray[numOfNums] = value;
      numOfNums++;
    }

    private void growCapcity(){

      numsArray = Arrays.copyOf( numsArray, numsArray.length * 2 );
      // System.out.println("---growCapcity() is called, new capacity: " + numsArray.length+ "---");
    }

    /**
       Return the minimum value in the sequence.
       If the sequence is empty, returns Integer.MAX_VALUE
     */
    public int minVal() {

      int minVal = Integer.MAX_VALUE;
      if(numOfNums >= 1){           // the non-empty case
        int curMin = numsArray[0];  // assume 1st is the minVal
        for(int i = 1; i < numOfNums; i++){
          if( numsArray[i] < curMin ){
            curMin = numsArray[i];
          }
        }
        minVal = curMin;
      }
	    return minVal;
    }

    /**
       Prints out the sequence of values as a space-separated list
       on one line surrounded by parentheses.
       Does not print a newline.
       E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
    */
    public void printVals() {

      System.out.print( "(" );

      if(numOfNums >= 1){
        System.out.print(numsArray[0]);// 1st element with no white space preceding itself.

        for(int i = 1; i < numOfNums; i++){
          System.out.print(" " + numsArray[i]);
        }
      }

      System.out.print( ")" );
    }

    /**
       Returns a new Nums object with all the values from this Nums
       object that are above the given threshold.  The values in the
       new object are in the same order as in this one.
       E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
             returns      (19 21 19)
             myNums after call:  (3 7 19 4 21 19 10)
       The method does not modify the object the method is called on.
     */
    public Nums valuesGT(int threshold) {
      Nums numGT = new Nums();
      for( int i = 0; i < numOfNums; i++){
        if(numsArray[i] > threshold){
          numGT.add(numsArray[i]);
        }
      }
      return numGT;  // stub code to get it to compile
    }


}
