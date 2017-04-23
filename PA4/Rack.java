// Name: Mingkai Cao    
// USC NetID: mingkaic  
// CS 455 PA4
// Spring 2017

import java.util.ArrayList;
import java.util.Arrays;


/**
   A Rack of Scrabble tiles
 */
public class Rack {
   /**
      Representation
      @param unique : unique letters in rack. Like 'abc' in rack 'aabbbcccc'
      @param mult   : corresponding occurence times for unique letters
   */ 
   private String unique;
   private int[] mult;

   private final int CHAR_TOTAL = 26;  // totally 26 characters
   private final char ASCII_LOWER_A = 'a' ;     // ASCII code  'a' = 97
   private final char ASCII_LOWER_Z = 'z' ;     // ASCII code  'z' = 112


   public Rack( String target ){
      // sanitize and lower the input rack
      String targetSanit = target.replaceAll("[^A-Za-z]", "");
      String targetLower = targetSanit.toLowerCase();
      int len = targetLower.length();
      if( len > 0 ){
         char[] uniqueArray = new char[len];
         mult = new int[CHAR_TOTAL];

         // count mult for each character
         int[] charMult = new int[CHAR_TOTAL];
         for( int i = 0; i < len; i++){
            char curChar = targetLower.charAt(i);
            charMult[ curChar - ASCII_LOWER_A ]++;
         }
         
         // only store 'existing' character in unique
         int j = 0;  
         for( byte i = 0; i < CHAR_TOTAL; i++ ){
            if( charMult[i] != 0 ){
               uniqueArray[j] = (char)(i + ASCII_LOWER_A);
               // System.out.println(uniqueArray[j]);
               mult[j++] = charMult[i];
            }
         }
         unique = new String( Arrays.copyOfRange(uniqueArray, 0, j) );
         mult = Arrays.copyOfRange(mult, 0, j);
      }
      else{
         unique = "";
         mult = new int[1];
      }   
   }

   /**
     Get all the subset of the rack 
     @return return the subset in form of ArrayList
   */
   public ArrayList<String> getAllSubsets() {
      ArrayList<String> allSubsets = allSubsets(unique, mult, 0);
      // NOTE: return value contain a empty string in the front
      // remove the empty string in the front
      allSubsets.remove(0);
      return allSubsets;
   }

   /**
     Finds all subsets of the multiset starting at position k in unique and mult.
     unique and mult describe a multiset such that mult[i] is the multiplicity of the char
          unique.charAt(i).
     PRE: mult.length must be at least as big as unique.length()
     @param unique a string of unique letters
     @param mult the multiplicity of each letter from unique.  
     @param k the smallest index of unique and mult to consider.
     @return all subsets of the indicated multiset
     @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {

      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
