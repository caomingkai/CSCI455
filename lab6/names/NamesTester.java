/**
   Unit test program for Names class
   Uses hard-coded data (no user input).
 */
public class NamesTester {


    public static void main(String[] args) {

        testLookup();

        testInsert();

        testRemove();

        testAllThree();
    }


    /**
       Tests lookup method
       (on empty names object, and one with names from loadNames())
    */
    private static void testLookup() {
	System.out.println("Testing lookup method...");

        Names names = new Names();

        names.loadNames();
        System.out.println("Names in list: ");
        names.printNames();
        System.out.println("Number of names in list [exp: 5]: " +
                names.numNames());	

        doOneLookup(names, "Dave");
        doOneLookup(names, "Abby");
        doOneLookup(names, "Matt");
        doOneLookup(names, "Anne");
        doOneLookup(names, "Don");
        doOneLookup(names, "Ed");

        System.out.println("Do lookup in an empty list: ");
        Names empty = new Names();
        System.out.println("Names in list: ");
        empty.printNames();
        System.out.println("Number of names in list [exp: 0]: " +
                empty.numNames());	

        System.out.println("Do lookup in an empty list: ");
        doOneLookup(empty, "Sam");
        doOneLookup(empty, "Anne");

        System.out.println();
    }


    /**
       Tests insert method

       Note: Uses "new" to create Strings to ensure they will be distinct
       objects from any other strings they are compared with (exposes
       equals vs. == bugs).
    */
    private static void testInsert() {

	System.out.println("Testing insert method...");

        Names names = new Names();

        System.out.println("Names in list [exp: <empty>]: ");
        names.printNames();
        System.out.println("Number of names in list [exp: 0]: " +
                names.numNames());	

        doOneInsert(names, new String("Sam"), "Sam", 1);
        doOneInsert(names, new String("Joe"), "Joe Sam", 2);
        doOneInsert(names, new String("Rosy"), "Joe Rosy Sam", 3);
        doOneInsert(names, new String("Ralph"), "Joe Ralph Rosy Sam", 4);
        doOneInsert(names, new String("Suzy"), "Joe Ralph Rosy Sam Suzy", 5);
        doOneInsert(names, new String("Henry"), "Henry Joe Ralph Rosy Sam Suzy", 6);
        doOneInsert(names, new String("Jack"), "Henry Jack Joe Ralph Rosy Sam Suzy", 7);

        System.out.println();

    }


    /**
       Tests remove method
       (on empty names object, and one with names from loadNames())
     */
    private static void testRemove() {

	System.out.println("Testing remove method...");

        Names names = new Names();
        names.loadNames();       // uses the hardcoded names

	System.out.println("Testing on empty list: ");

	doOneRemove(new Names(), "Carol", "<empty>", 0);

	System.out.println("Testing on non-empty list: ");
        System.out.println("Original list: ");
        names.printNames();

        doOneRemove(names, "Scotty", "Anne Bob Carol Don Ed", 5);
        doOneRemove(names, "Anne", "Bob Carol Don Ed", 4);
        doOneRemove(names, "Ed", "Bob Carol Don", 3);
        doOneRemove(names, "Ed", "Bob Carol Don", 3);
        doOneRemove(names, "Carol", "Bob Don", 2);
        doOneRemove(names, "Bob", "Don", 1);
        doOneRemove(names, "Don", "", 0);

        System.out.println();

    }


    /**
       Tests of insert, remove, and lookup.

       This method does not use loadNames.

       Note: Uses "new" to create Strings to ensure they will be distinct
       objects from any other strings they are compared with (exposes
       equals vs. == bugs).

     */
    private static void testAllThree() {

	System.out.println("Testing insert/lookup/remove methods together...");

	Names names = new Names();
	
	doOneInsert(names, new String("Joe"), "Joe", 1);
	doOneInsert(names, new String("Abby"), "Abby Joe", 2);
	doOneRemove(names, new String("Abe"), "Abby Joe", 2);
	doOneRemove(names, new String("Abby"), "Joe", 1);
	doOneLookup(names, new String("Abby"));
	doOneLookup(names, new String("Joe"));
	doOneInsert(names, new String("Sam"), "Joe Sam", 2);
	doOneInsert(names, new String("Paul"), "Joe Paul Sam", 3);
	doOneRemove(names, new String("Paul"), "Joe Sam", 2);
	doOneLookup(names, new String("Sam"));

        System.out.println();
    }


    /**
       Test lookup of target in names, and prints results.
     */
    private static void doOneLookup(Names names, String target) {
        System.out.print("Looking up " + target + " . . . ");
        if (names.lookup(target)) {
            System.out.println("found");
        }
        else {
            System.out.println("not found");
        }
    }


    /**
       Test remove of goner on names, and prints actual and expected results.
       @param names the names object we are testing
       @param goner the element to remove from names
       @param expectedResult a space-separated string values expectd in names after 
                             remove is done (e.g., "Anne Bob Ed")
       @param expectedSize: expected value for names.numNames() after remove is done
     */
    private static void doOneRemove(Names names, String goner, 
            String expectedResult,
            int expectedSize) {
        System.out.println("Attempt remove: " + goner);

        boolean removed = names.remove(goner);

        if (!removed) {
            System.out.println(goner + " was not present");
        }

        System.out.println("Names in list [exp: " + expectedResult + "]: ");
        names.printNames();
        System.out.println("Number of names in list [exp: "
                + expectedSize + "]: " +
                names.numNames());	
    }


    /**
       Test insert of newName on names, and prints actual and expected results.
       @param names the names object we are testing
       @param newName the value to insert into names
       @param expectedResult a space-separated string values expectd in names after
                             insert is done (e.g., "Anne Bob Ed")
       @param expectedSize: expected value for names.numNames() after insert is done
     */
    private static void doOneInsert(Names names,
            String newName, 
            String expectedResult, 
            int expectedSize) {

        System.out.println("Attempt insert: " + newName);
        names.insert(newName);
        System.out.println("Names in list [exp: "
                + expectedResult + "]: ");
        names.printNames();
        System.out.println("Number of names in list [exp: "
                + expectedSize + "]: " +
                names.numNames());	

    }


}
