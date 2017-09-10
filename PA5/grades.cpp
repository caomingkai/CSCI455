// Name: Mingkai Cao
// Loginid: mingkaic
// CSCI 455 PA5
// Spring 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>


// handle user input
void handleInput( Table *grades );

// deal with insert command
void insertCmd( Table *grades );

// deal with change command
void changeCmd( Table *grades );

// deal with lookup command
void lookupCmd( Table *grades );

// deal with remove command
void removeCmd( Table *grades );

// deal with print command
void printCmd( Table *grades );

// deal with size command
void sizeCmd( Table *grades );

// deal with statics command
void statsCmd( Table *grades );

// deal with help command
void helpCmd();




int main(int argc, char * argv[]) {

  // gets the hash table size from the command line
  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int
    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }
    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }

  grades->hashStats(cout);
  handleInput( grades );  // handle user input
  return 0;
}

// handle user input
void helpCmd();
   void handleInput( Table *grades ){
      std::string cmd;
      cout << "cmd> ";
      cin >> cmd;
      while( cmd != "quit" ){

         if( cmd == "insert"){
            insertCmd( grades );

         }else if( cmd == "change" ){
            changeCmd( grades );

         }else if(  cmd == "lookup" ){
            lookupCmd( grades ); 

         }else if(  cmd == "remove" ){
            removeCmd( grades ); 

         }else if(  cmd == "print" ){
            printCmd( grades );

         }else if(  cmd == "size" ){
            sizeCmd( grades );

         }else if(  cmd == "stats" ){
            statsCmd( grades );

         }else if(  cmd == "help" ){
            helpCmd();

         }else{
            cout<< "ERROR: invalid command"<<endl; 
            helpCmd();
         }

         cout<< "cmd> ";
         cin >> cmd;
       }
   }


// deal with insert command
   // @param grades , the grades table
void insertCmd( Table *grades ){
   std::string name;
   std::string score;
   cin >> name >> score;

   int scoreInt = atoi(score.c_str());
   bool done = grades->insert( name, scoreInt );
   if( done == false ){
      cout << "  Item already exist. " << endl;
   }
}



// deal with change command
// @param grades , the grades table
void changeCmd( Table *grades ){
   std::string name;
   std::string score;
   cin >> name >> score;
   int scoreInt = atoi(score.c_str());

   int* targetIntAddr = grades->lookup( name );
   if( targetIntAddr == NULL ){
       cout << " No such item exist, insertion done." << endl;
   }else{
       grades->remove( name );
       grades->insert( name , scoreInt );
   }
}



// deal with lookup command
// @param grades , the grades table
void lookupCmd( Table *grades ){

   std::string name;
   cin >> name;
   int* targetIntAddr = grades->lookup( name );

   if( targetIntAddr == NULL ){
       cout << " No such item exist." << endl;
   }else{
       cout << " Score is: " << *targetIntAddr << endl;
   }
}


// deal with remove command
// @param grades , the grades table
void removeCmd( Table *grades ){

   std::string name;
   cin >> name;
   int* targetIntAddr = grades->lookup( name );

   if( targetIntAddr == NULL ){
       cout << " No such item exist." << endl;
   }else{
       grades->remove(name);
   }
}


// deal with print command
// @param grades , the grades table
void printCmd( Table *grades ){
   grades->printAll();
}


// deal with size commad
// @param grades , the grades table
void sizeCmd( Table *grades ){
   cout << grades->numEntries()<<endl;
}


// deal with statics command
// @param grades , the grades table
void statsCmd( Table *grades ){
   grades->hashStats(cout);
}


// deal with help command
void helpCmd(){
   cout << "insert name score    : Insert this name and score in the grade table." << endl;
   cout << "change name newscore : Change the score for name. " << endl;
   cout << "lookup name          : Lookup the name." << endl;
   cout << "remove name          : Remove this student." << endl;
   cout << "print                : Prints out all names and scores in the table." << endl;
   cout << "size                 : Prints out the number of entries in the table." << endl;
   cout << "stats                : Prints out statistics about the hash table at this point." << endl;
   cout << "quit                 : Exits the program." << endl;
}
