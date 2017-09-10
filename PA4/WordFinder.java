// Name: Mingkai Cao    
// USC NetID: mingkaic  
// CS 455 PA4
// Spring 2017

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
  1. read 'anagram dictionary' from console input
  2. keep reading 'rack' from console input
  3. create scoreTable with obtained rack and anagram dictionary
  4. print out the result
 */
public class WordFinder{

	private static final String DEFAULT_FILE = "sowpods.txt"; // defulat anagram dictionary


	public static void main(String[] args){

		// Read file, pass it to anagramDict, and create anagramDict
		AnagramDictionary anagramDict = null;
		String fileName = DEFAULT_FILE;
		int len = args.length;

		try{
			if( len == 0 ){		// using default anagram dictionary
				anagramDict = new AnagramDictionary( fileName );
			}else{				// using anagram dictionary from input
				fileName = args[0];
				anagramDict = new AnagramDictionary( fileName );
			}
			// Keep accepting rack input, calculate, and print out result
            
            
            
                
			System.out.println("Type . to quit.");
			System.out.print("Rack? ");
			Scanner in = new Scanner( System.in );
			String rackInput = in.nextLine();

			while( !rackInput.equals(".") ){
				printResult( rackInput , anagramDict );
				System.out.print("Rack? ");
				rackInput = in.nextLine();
			}
		}
		catch( FileNotFoundException e ){
			System.out.println("Error: " + fileName + " doesn't exist.");
			System.exit(0);
		}
		catch( IOException e){
			e.printStackTrace();
		}
		catch( Exception e){
            e.printStackTrace();
        }
	}



    /**
      Calculate the final ScoreTable for given rack and anagram dictionary
      @param rack: rack input from user input
      @param rack: anagram dictionary
    */
	private static void printResult( String rackInput, AnagramDictionary anagramDict ){

		// create rack objct
		Rack rack = new Rack( rackInput );

		// obtain the nonsense rack form according to PA description
		String rackInputLower = rackInput.replaceAll("[^A-Za-z]", "").toLowerCase();
		char[] ar = rackInputLower.toCharArray();
		Arrays.sort(ar);
		String canonStr = String.valueOf(ar);

		// create scoreTable to calculate the final result
		ScoreTable scoreTable = new ScoreTable( rack, anagramDict);
		ArrayList< Map.Entry<String, Integer> > finalScore = scoreTable.getScoreTable();
		int length = finalScore.size();

		System.out.println( "We can make " + length + " words from \"" + canonStr +"\"");
		if( length > 0){
			System.out.println( "All of the words with their scores (sorted by score): " );
			for( Map.Entry<String, Integer> entry : finalScore ){
				System.out.print( entry.getValue() + ": "); 
				System.out.println( entry.getKey() );
			}
		}
	}


}
