// Name: Mingkai Cao    
// USC NetID: mingkaic  
// CS 455 PA4
// Spring 2017

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;



/**
  A dictionary of all anagram sets. 
  Note: the processing is case-sensitive; so if the dictionary has all lower
  case words, you will likely want any string you test to have all lower case
  letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {
   /**
     Representation: HashMap
     1. key   : canonical string entry, like 'abbccc'
     2. value : anagram string entries, like {'acccbb', 'acbcbc', 'abcccb', ... }
   */
   private Map< String, ArrayList<String> > anagramDict;


   /**
     Create an anagram dictionary from the list of words given in the file
     indicated by fileName.  
     PRE: The strings in the file are unique.
     @param fileName  the name of the file to read from
     @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException, IOException{

      anagramDict = new HashMap< String, ArrayList<String> >();

      BufferedReader bufferR = null;
      try{
         bufferR = new BufferedReader( new FileReader( fileName) );
         String entry = bufferR.readLine();
         while( entry != null ){
            insertEntry( entry );   // put each entry into the HashMap anagramDict
            entry = bufferR.readLine();
         }
      }
      finally{
         try{
            bufferR.close();
         }
         catch( FileNotFoundException e ) {
            System.out.println("FileNotFoundException in Closing the BufferedReader");
         }
         catch( Exception e){
            System.out.println("Exception in Closing the BufferedReader");
         }
      }
   }
   

   /**
     Get all anagrams of the given string. This method is case-sensitive.
     E.g. "CARE" and "race" would not be recognized as anagrams.
     @param s string to process
     @return a list of the anagrams of s 
    */
   public ArrayList<String> getAnagramsOf(String s) {

      String entryKey = orderEntry( s );     // put letters in order
      ArrayList<String> entryList = anagramDict.get(entryKey);
       
      if( entryList != null ){
         return new ArrayList<String>( entryList );
      }
      return null;
   }
   

   /**
     Insert each entries from a dictionary to create the anagram dictionary (HashMap)
     @param entry : entry to be inserted
    */
   private void insertEntry( String entry ){

      String entryKey = orderEntry( entry );     // put letters in order
      ArrayList<String> entryList = getAnagramsOf( entryKey );

      if( entryList != null ){                   // Case: already exist an entryList
         entryList.add( entry );
         anagramDict.put( entryKey, entryList );
      }else{                                     // Case: new entry 
         entryList = new ArrayList<String>(); 
         entryList.add( entry );
         anagramDict.put( entryKey, entryList ); // NOTE: Must put back again
      }
   }

   /**
     make the entry in alphbetical order
     @param entry : entry to be inserted
     @return return an ordered entry 
    */
   private String orderEntry( String entry ){
      char[] entryCharArr =  entry.toCharArray();
      Arrays.sort( entryCharArr );
      return new String( entryCharArr );
   }
   
}
