/*  Name:
 *  USC NetID:
 *  CS 455 Spring 2017
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


int lastIndexOf(ListType list, int val) {
	
	ListType p = list;
	int i = -1;
	int lastIndexOf = -1;
	if( p == NULL ){
		return lastIndexOf;
	}
	

	do
	{	i++;
		if( p->data == val ){
			lastIndexOf = i;
		}
		p = p->next;

	} while( p != NULL );

  return lastIndexOf;  // stub code to get it to compile
}



void removeFollowingEvens(ListType &list) {
	
	ListType p = list;
	while( p != NULL ){

		if( p->data % 2 == 0 ){
			Node *firstEven = p;
			while( firstEven->next != NULL && firstEven->next->data % 2 == 0){
				Node * temp = firstEven->next->next;
				delete firstEven->next;
				firstEven->next = temp;
			}
		}
		p = p->next;
	}
}



void mirrorList(ListType & list) {

	ListType p = list;
	if( p != NULL ){
		Node * sentinel = new Node( p->data );
		Node * temp = p;

		p = p->next;
		while( p != NULL ){
			temp = p;
			Node* toBeInsert = new Node( p->data );
			toBeInsert->next = sentinel;
			sentinel = toBeInsert;
			p = p->next;
		}
		temp->next = sentinel;
	}
}



void rotateRight(ListType &list, int k) {

	ListType p = list;
	int len = 0;
	Node * first = p;
	Node * last = NULL;

	while( p != NULL ){
		len++;
		last = p;
		p = p->next;
	}
	
	if( k < 0 || k >= len ){
		return;
	}

	int i = 0;
	Node * toBeLast = first;

	while( i < len - k  - 1){
		toBeLast = toBeLast->next;
		i++;
	}

	last->next = first;
	list = toBeLast->next;
	toBeLast->next = NULL;
}









