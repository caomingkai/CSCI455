#include <iostream>
using namespace std;


void printArray( int *arr, int size ){
	for(int i = 0 ; i < 10; i++ ){
 		cout << arr[i] << " ";
 	}
	cout << endl;
}

// void printArray( int arr[], int size ){
//  	for(int i = 0 ; i < 10; i++ ){
//  		cout << arr[i];
//  	}
// 	cout << endl;
// }


int main( int argc, char* argv [] ){

	int a[10];
	for(int i = 0; i < 10; i++){
		a[i] = i;
	}

	int *b = new int[10];

	for(int i = 0; i < 10; i++){
		b[i] = i+10;
	}

	printArray(a, 10);
	printArray(b, 10);

}