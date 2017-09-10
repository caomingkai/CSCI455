// Name: Mingkai Cao    
// USC NetID: mingkaic  
// CS 455 PA4
// Spring 2017

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;



/**
  Calculate the final ScoreTable for corresponding rack 
  get both the rack object and anagramDict object from main method in Class WordFinder
  based on the character score, give out the score table
 */
public class ScoreTable{

	/**
	   @param rack : the rack object containing rack content
	   @param anagramDict : the anagram dictionary to be find with
	 */ 
	private Rack rack;
	private AnagramDictionary anagramDict;
	    										  // score for each character
	private final int[] CHAR_SCORE = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3,
									  1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
   	private final char ASCII_LOWER_A = 'a' ;      // ASCII code 'a' = 97


   /**
      Constructs a ScoreTable.
      @param rack: the rack object passed from main method in Class WordFinder
      @param anagramDict: the anagramDict object passed from main method
    */
	public ScoreTable( Rack rack, AnagramDictionary anagramDict ){
		this.rack = rack;
		this.anagramDict = anagramDict;
	}


   /**
      return final ordered result table
      @return return final ordered result table in form of ArrayList
    */
	public ArrayList< Map.Entry<String, Integer> > getScoreTable(){

		// obtain entries (TreeMap) in alphebetical order
		Map< String, Integer> tableDesc = calcAll();
		List< Map.Entry<String, Integer> > entryList =
		 			new ArrayList< Map.Entry<String, Integer> >( tableDesc.entrySet() );
		// sort alphabetical ordered entries by their scores
		Collections.sort( entryList, new TreeMapComp() ); 

		return new ArrayList< Map.Entry<String, Integer> >(entryList);
	}



	/**
	  Calculate all anagram entry scores for all the subsets of the rack
		  1. get all subset from 'rack'
		  2. search the 'anagramDict'
		  2. find out all matching entries, and
	      4. calculate their scores in form of Map< String, Integer>
      @return return result scores in alphebetical order, nothing to do with their score
    */
	private Map< String, Integer> calcAll(){
		// put result in a TreeMap with alphbetical order
		TreeMap< String, Integer> resultTable = new TreeMap< String, Integer>();
		// get all canonical subsets from rack
		ArrayList<String> rackSubset = rack.getAllSubsets();
		ListIterator<String> oneItem = rackSubset.listIterator(); 

		while( oneItem.hasNext() ){   		  // canonical entry
			ArrayList<String> oneResult = anagramDict.getAnagramsOf( oneItem.next() );
			if( oneResult != null ){

				// loop through anagram entries for current canonical entry				
				ListIterator<String> oneResultE = oneResult.listIterator();
				while( oneResultE.hasNext() ){ // anagram entry

					String anagramItem = oneResultE.next();
					int itemScore = calcOne( anagramItem );
					resultTable.put( anagramItem, itemScore );
				}
			}
		}
		return resultTable;
	}



	/**
	  Calculate ONE anagram entry score for current canonical subset of the rack
      @return return score for ONE of anagram item
    */
	private int calcOne( String anagramItem ){
		int score = 0;
		int len = anagramItem.length();
		for(int i = 0; i < len; i++){
			score += CHAR_SCORE[ anagramItem.charAt(i) - ASCII_LOWER_A ];
		}
		return score;
	}



	/**
	  Sort TreeMap entries by score via this custom comparator
    */
	public class TreeMapComp implements Comparator< Map.Entry<String, Integer> >{

		public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
			if (e1.getValue() < e2.getValue()) {   //  entry with larger score get printed first
				return 1; 
			}
			if(e1.getValue() == e2.getValue()){
				return 0; 	
			}
			return -1;
		}
	}



}








			