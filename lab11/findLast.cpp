#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using std::cin;
using std::cout;
using std::endl;
using std::vector;
using std::string;

vector<int> readVals();
void print( vector<int> v );
void printVals( vector<int> v );
vector<int> valsGT0( vector<int> v );
int findLast(vector<int> v, int target);
void testFindLast();

int main(){

	testFindLast();
    return 0;
}

void testFindLast(){
	vector<int> values;
	cout << "input the vector: \n" ;
	values = readVals();

	vector<int> targetVec;
	cout << "input the target: \n" ;
	targetVec = readVals();
	int target = targetVec[0];

	cout << findLast(values , target) << endl;
}


int findLast( vector<int> v, int target){
	
	int len = v.size();
	int i = len - 1;

	while( v[i] != target ){
		if( i == -1 ){
			return -1;
		}
		i--;
	}
	return i;
}


vector<int> readVals(){

    string inputStr;
    std::getline( cin, inputStr );
    std::stringstream ss( inputStr );

    vector<int> values;
    int val;
    while( ss >> val ){
        values.push_back( val );
    }

    return values;
}

void print( vector<int> v ){

	int i = 0;
	int len = v.size();

	while(i < len){
		cout << v[i] << " ";
		i++;
	}
	cout << "\n";
}

void printVals( vector<int> v ){

	int i = 0;
	int len = v.size();
	cout << "Vector: ";

	while(i < len){
		cout << v[i] << " ";
		i++;
	}
	cout << "\n";
}


vector<int> valsGT0( vector<int> v ){

	int i = 0;
	int len = v.size();
	vector<int> vGT0;

	while(i < len){
		if( v[i] > 0 ){
			vGT0.push_back( v[i] );
		}
		i++;
	}
	return vGT0;
}






