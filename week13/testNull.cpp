#include <iostream>

using namespace std;

int main() {

  char *c;

  cout << "\"" <<  *c << "\"" << endl;  // surround char with "

  c = new char;

  cout << "\"" <<  *c << "\"" << endl;

  *c = 'm';

  cout << "\"" <<  *c << "\"" << endl;

  c = NULL;

  cout << "\"" <<  *c << "\"" << endl;

  if (c != NULL) {
    cout << "\"" <<  *c << "\"" << endl;
  }
  else {
    cout << "c is NULL: can't dereference" << endl;
  }

  return 0;

}