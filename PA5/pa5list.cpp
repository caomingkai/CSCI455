// Name:
// loginid:
// CS 455 PA5

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

	ListType myList;
	listInit(myList);
	cout<<" 1---'listInit()'test, next line should be empty"<<endl;
	listPrint(myList);

	cout<<" 2---'listInsert()'test,should be: a 1"<<endl;
	listInsert( "a" , 1 , myList);
	listPrint(myList);
	cout<<" 2---'listInsert()'test,should be: a 1 b 2"<<endl;
	listInsert( "b" , 2 , myList);
	listPrint(myList);
	cout<<" 2---'listInsert()'test,should be: a 1 b 2 c 3"<<endl;
	listInsert( "c" , 3 , myList);
	listPrint(myList);


	cout<<" 3---'listNumEntries()'test, should be: 3"<<endl;
	cout << listNumEntries(myList) << endl;

	cout<<" 4---'listRemove()'test,should be b 2 c 3"<<endl;
	listRemove( "a" , myList );
	listPrint(myList);

	cout<<" 4---'listRemove()'test,should be empty"<<endl;
	listRemove( "b" , myList );
	listRemove( "c" , myList );
	listPrint(myList);


	cout<<" 5---'listLookup()'test,should be"<<endl;
	listInsert( "a" , 1 , myList);
	int * targetAddr = listLookup( "a" , myList);
	cout << "targetAddr: " << targetAddr << endl;
	listPrint(myList);
	*targetAddr = 1000;
	listPrint(myList);


  	return 0;
}






