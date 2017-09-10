#include <iostream>

using namespace std;

struct Node {
int data;
Node * next;
Node() { data = 0; next = NULL; }
Node(int d) { data = d; next = NULL; }
Node(int d, Node * n) { data = d; next = n; }
};
typedef Node * ListType;


ListType fibSeq(int n){

	Node * former = new Node(1);
	Node * latter = new Node(1);

	Node * header = former;

	if( n == 1 ){
		return header;
	}

	if( n == 2){
		former->next = latter;
		return header;
	}

	former->next = latter;
	for( int i = 3; i <= n; i++){
		Node * temp = new Node( former->data + latter->data );
		latter->next = temp;
		former = latter;
		latter = temp;
	}
	return header;
}

int main( int argc, char * argv[] ){

	int n = 8;
	cout<< "FibSeq " << n << " is: ";
	Node * p = fibSeq(n);
	while( p != NULL ){
		cout << p->data << " ";
		p = p->next;
	}

	cout<< endl;

	Node *a = new Node(1);
	Node *b = a;

	cout << "*a:  " << (*a).data <<endl; 
	cout << "a:  " << a <<endl;
	cout << "b:  " << b <<endl;

	cout << "&a:  " << &a <<endl;
	cout << "&b:  " << &b <<endl;
}




