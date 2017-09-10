#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using std::cin;
using std::cout;
using std::vector;
using std::string;


vector<int> readVals();
void printVals( vector<int> v );


int main(){

	vector<int> values;
    values = readVals();
    printVals( values );

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