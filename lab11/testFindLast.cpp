#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using std::cin;
using std::cout;
using std::vector;
using std::string;

vector<int> readVals();
void print( vector<int> v );
void printVals( vector<int> v );
// returns a vector of values from v that are greater than 0
// these values are in the same relative order as they are in v.
vector<int> valsGT0( vector<int> v );
// returns location of last instance of target in v or -1 if not found
int findLast(vector<int> v, int target);

int main(){

	vector<int> values;
    values = readVals();
    printVals( values );
	
	vector<int> vGT0;
    vGT0 = valsGT0( values );
    cout << "Filtered vector: ";
    print(vGT0);
    cout << "Original vector: ";
    print(values);

    return 0;
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






