// Name: Mingkai Cao
// Loginid: mingkaic
// CSCI 455 PA5
// Spring 2017



// Table.cpp  Table class implementation
/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// initialize Table class without no parameter
Table::Table() {
	hashSize = HASH_SIZE;
	tableData = new ListType[ hashSize ]; // data is array of listType
										  // data[0];this expression is type ListType (= Node*)
    for (int i = 0; i < hashSize; i++) {
        tableData[i] = NULL;
    }
}


// initialize Table class without a parameter indicating hash size
// @param hSize, indicating hash size
Table::Table(unsigned int hSize) {
	hashSize = hSize;
	tableData = new ListType[ hashSize ]; // data is array of listType
    
    for (int i = 0; i < hashSize; i++) {
        tableData[i] = NULL;
    }
}


// look up for a name in table
// @param key, reference of the passed name
// @return a pointer to corrsponding score
int * Table::lookup(const string &key) {
    int hashIndex = hashCode( key );
	return( listLookup( key, tableData[hashIndex] ) );
}

// remove name in table
// @param key, reference of the passed name
// @return a bool value to indicate success or not
bool Table::remove(const string &key) {
	
	int hashIndex = hashCode( key );
	return( listRemove( key , tableData[hashIndex]) );
}

// insert a certain name in table
// @param key, reference of the passed name
// @return a bool value to indicate success or not
bool Table::insert(const string &key, int value) {

	int hashIndex = hashCode( key );
  	return( listInsert( key , value, tableData[hashIndex]) );
}

// obtain the number of table entries
// @return a the number
int Table::numEntries() const {
	
	int sum = 0;

	for(int i=0; i < hashSize; i++){

		sum += listNumEntries( tableData[i] );
	}

  	return sum; 
}

// print all the entries in the table
void Table::printAll() const {

	for(int i = 0; i < hashSize; i++ ){
		listPrint( tableData[i] );
	}
}

// print out the status of the hashtable
// @param out, the standard output 
void Table::hashStats(ostream &out) const {
	
   	out << "number of buckets: " <<  hashSize << endl;
   	out << "number of entries: " <<  numEntries() << endl;
   	out << "number of non-empty buckets: " <<  getNonEmptyBucketsNum() << endl;
   	out << "longest chain: " <<  getLongestChainNum() << endl;
}


// obtain the number of non-empty Bucket 
// @return the number
int Table::getNonEmptyBucketsNum()const{
	int nonEmpNum = 0;
   	for( int i = 0; i < hashSize; i++ ){
   		if( tableData[i] != NULL ){
   			nonEmpNum++;
   		}
   	}
   	return nonEmpNum;
}

// obtain the number of longest chain items
// @return the number
int Table::getLongestChainNum()const{

	int longestNum = 0;
	for(int i = 0; i < hashSize; i++ ){
		int listLength = listNumEntries( tableData[i] );

		longestNum = listLength > longestNum ?  listLength : longestNum;
	}
    return longestNum;
}

