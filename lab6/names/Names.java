import java.util.ArrayList;

/**
   Names class -- version for lab 6

   Stores a list of unique names in alphabetical order.  Allows
   look-up, insert, and removal of elements in the list.

   NOTE about implementation: In previous semesters we used this
   ArrayList version of the code in our lecture example so that we
   could take advantage of the automatic memory management that
   ArrayList takes care of (e.g., we just call "add" here, we don't
   have to implement it or a growArray method).

   This version of the code still uses loops to do insert, remove, and
   lookup, to get practice with array manipulation, even though using
   some of the other ArrayList methods could make some of the code
   shorter (although not faster).

*/
public class Names {

    /**
       Creates an empty names object
     */
    public Names() {
	namesArr = new ArrayList<String>();
    }

    /**
       Returns the number of names in the list
    */
    public int numNames() {
	return namesArr.size();
    }

    /**
       Returns true iff target is present in names
     */
    public boolean lookup(String target) {
	int loc = lookupLoc(target);

	// SHOW using a boolean expression in a non-test
	return loc != NOT_FOUND;
    }

    /**
       Removes target from names, and returns true.
       If target wasn't present in names, returns false and no change
       made to names.
    */
    public boolean remove(String target) {
	int loc = lookupLoc(target);

	if (loc == NOT_FOUND) {  // there's nothing to remove
	    return false;
	}
	else {
	    int lastLoc = namesArr.size()-1;
	    for (int i = loc; i < lastLoc; i++) {
		namesArr.set(i, namesArr.get(i+1));
	    }
	    // decrease size() by one
	    // guy that was at lastloc was already copied one to the left
	    // in the loop above
	    namesArr.remove(lastLoc);

	    return true;
	}
	
    }

    /**
       Inserts newName into alphabetical names list.  
       Returns false and no change is made to names if name is already
       present.
     */
    public boolean insert(String newName) {

	int targetLoc = 0;

	while (targetLoc < namesArr.size() 
	       && newName.compareTo(namesArr.get(targetLoc)) > 0) {

	    targetLoc++;

	}

	if (targetLoc < namesArr.size() 
	    && newName.equals(namesArr.get(targetLoc))) {

	    return false;   // newName is already there

	}
	else {  

	    // Increase size() by one ("" is a dummy value)
	    namesArr.add(""); 

	    // shift all the elements over to make room for the new
	    // element

	    for (int i = targetLoc; i < namesArr.size() - 1; i++) {

		namesArr.set(i+1, namesArr.get(i));
	    }

	    namesArr.set(targetLoc, newName);

	    return true;
	}

    }


    /**
       Prints the names in alpha order, one per line
    */
    public void printNames() {
	for (int i = 0; i < namesArr.size(); i++) {
	    System.out.println(namesArr.get(i));
	}
    }


    /**
       NOTE: For testing purposes only.  

       Loads some of hardcoded names into the list in alphabetical
       order, without using Names insert method.  Only works on an
       empty names object.  If it is empty before, after the operation the
       names object contains: Anne, Bob, Carol, Don, Ed
     */
    public void loadNames() {
	if (numNames() == 0) {
	    namesArr.add(new String("Anne"));
	    namesArr.add(new String("Bob"));
	    namesArr.add(new String("Carol"));
	    namesArr.add(new String("Don"));
	    namesArr.add(new String("Ed"));
	}
    }


    //************************************************************
    // private method section 


    /**
       returns location of target or NOT_FOUND if not found
    */
    private int lookupLoc(String target) {
	int i = 0;

	// SHOW short-circuit &&
	while (i < namesArr.size() && !target.equals(namesArr.get(i))) {
	    i++;
	}
	// true here: i is loc of name, or i == size()

	if (i == namesArr.size()) {

	    /*
	    System.out.print("DEBUG: ");   // DEBUG PRINT STATEMENTS
	    System.out.println(target + " not found");
	    */

	    return NOT_FOUND;
	}
	else {

	    /*
	    System.out.print("DEBUG: ");   // DEBUG PRINT STATEMENTS
	    System.out.println(target + " found at location " + i);
	    */

	    return i;
	}

    }



    //************************************************************
    // private data section

    private ArrayList<String> namesArr;
    private final static int NOT_FOUND = -1;

    /**
       Representation invariant:      
           -- names are unique
	   -- names are in alphabetical order in namesArr
	   -- number of names stored is namesArr.size()
    */
    

}
