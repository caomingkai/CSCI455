// Name: Mingkai Cao
// Loginid: mingkaic
// CSCI 455 PA5
// Spring 2017

#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}



//*************************************************************************
// put the function definitions for your list functions below


// initialize an already declared list
void listInit(ListType & list){
    list = NULL;
}

// look for a target string in current list
// @param targetStr, target name
// @param list, current list
int * listLookup(const string &targetStr, const ListType & list) {

	ListType item = list;

	while( item != NULL ){
		if( item->key == targetStr){
			return &item->value;
		}else{
			item = item->next;
		}
	}
	return NULL;
}

// remove a target string in current list
// @param targetStr, target name
// @param list, current list
bool listRemove(const string &targetStr , ListType & list){

	ListType item = list;

	if( list == NULL ){  // in case no such list(bucket) to corresponding hashkey
		return false;
	}

	if( item->key == targetStr ){
		list = item->next;
		delete item;
		return true;
	}
	while( item->next != NULL ){
		if( item->next->key == targetStr ){
			ListType nxItem = item->next;
			item->next = nxItem->next;
			delete nxItem;
			return true;
		}
		item = item->next;
	}
	return false;
}

// insert a target string and target score into current list
// @param targetStr, target name
// @param targetval, target score
// @param list, current list
bool listInsert(const string &targetStr, int targetval , ListType & list){
 	
	if( list == NULL ){
		list = new Node( targetStr, targetval );
		return true;
	}

	ListType item = list;
	if( item->key == targetStr ){
		return false;
	}

	while( item->next != NULL ){
		if( item->next->key == targetStr ){
			return false;
		}
		item = item->next;
	}
	item->next = new Node( targetStr, targetval );
	return true;
}


// obtain the number of entries of the current list
// @param list, current list
int listNumEntries( const ListType & list ){

	int sum = 0;
	ListType item = list;

	while( item != NULL ){
		sum++;
		item = item->next;
	}
    
	return sum;
}



// print put all the entries for the current list
// @param list, current list
void listPrint( const ListType & list ){

	ListType item = list;

	while( item != NULL ){
		cout << item->key <<" ";
		cout << item->value << endl;
		item = item->next;
	}
}





