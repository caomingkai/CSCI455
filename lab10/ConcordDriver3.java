import java.util.Scanner;
import java.util.Map;
import java.util.Comparator;

/**
 * Finds frequency of each word in a file.  
 * (Version for Exercise 3.)
 *
 * Optional command line argument is the threshold for the number of
 * letters a word must have to be printed with its number of occurrences.
 *
 * If argument isn't given, prints all words and number of occurrences.
 *
 */

public class ConcordDriver3 {


    public static void main(String[] args) {

	int threshold = 0;

	if (args.length > 0) {
	    threshold = Integer.parseInt(args[0]);
	}

	Concord concord = new Concord();
		
	Scanner in = new Scanner(System.in);
		
	concord.addData(in);		
	

	// add code here to print out the selected entries

	// concord.printSatisfying(System.out, new LargeWordPred(threshold) );

	System.out.println( concord.findLongest() );

	}

}


// add new class here

 class LargeWordPred implements Predicate{

 	int length;

 	public LargeWordPred(int length){
 		this.length = length;
 	}

 	public boolean predicate(Map.Entry<String,Integer> item){
    	return item.getKey().length() - length > 0 ? true : false;
    }
 }


  class EntryLengthComparator implements Comparator<Map.Entry<String,Integer>>{

	public int compare(Map.Entry<String,Integer> entry1 , Map.Entry<String,Integer> entry2 ){

		return entry2.getKey().length() - entry1.getKey().length();
	}
}