// Name: Mingkai Cao
// Loginid: mingkaic
// CSCI 455 PA5
// Spring 2017


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.


// initialize an already declared list
void listInit(ListType & list);

// look for a target string in current list
// @param targetStr, target name
// @param list, current list
int * listLookup(const string &targetStr, const ListType & list) ;


// remove a target string in current list
// @param targetStr, target name
// @param list, current list
bool listRemove(const string &targetStr , ListType & list);


// insert a target string and target score into current list
// @param targetStr, target name
// @param targetval, target score
// @param list, current list
bool listInsert(const string &targetStr, int targetval , ListType & list);


// obtain the number of entries of the current list
// @param list, current list
int listNumEntries( const ListType & list );


// print put all the entries for the current list
// @param list, current list
void listPrint( const ListType & list );


#endif
