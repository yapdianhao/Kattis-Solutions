#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double n;
    cin >> n;
    cout.precision(7);
    cout << pow(n, (1 /n)) << endl;
}