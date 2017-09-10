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


int countRun(ListType p){

	bool inRun = false;
	int count = 0;

	if(p == NULL){return 0;}

	while(p->next != NULL ){
		if( p->data == p->next->data ){
			inRun = true;
		}else{
			if(inRun){
				inRun = false;
				count += 1;
			}
		}
		p = p->next;
	}

	if( inRun ){
		count += 1;
	}

	return count;
}



int main( int argc, char * argv[] ){


	ListType l = new Node(1);
	l->next = new Node(2, new Node(2, new Node(3, new Node(3, new Node(3, new Node(4, new Node(4)))))));
	ListType p = l;
	while( p != NULL ){
		cout << p->data << " ";
		p = p->next;
	}
	cout<< endl;


	cout << countRun(l)<<endl;

}




