#include <iostream>

using namespace std;

// finds all of n's factors
// not including 1 and itself
void factors (int n)
{
  int k = 2;

  while (k < n) {
    
    if (n % k == 0) {
      cout << k << endl;
    }
    k++;
  }
  
}

int main()
{

  int *a = 1;
  int b[2] = {2,2};
  int *c = &a;
  int* d = &b;

  cout << "a: " << a <<" - " << &a << endl;
  cout << "b: " << b <<" - " << &b[0] <<" - " << &b[1] << endl;
  cout << "c: " << c <<" - " << *c << endl;
  cout << "d: " << d <<" - " << *d << d[1] << endl;

  int n;
  cout << "Find factors of what number? ";
  cin >> n;
  cout << "Factors of n are: " << endl;
  factors (n);
  cout << endl;
}
