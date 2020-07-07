#include <iostream>

using namespace std;

int main() {

    int a, b, c;
    cin >> a >> b >> c;
    while (a != 0 ||  b != 0  || c != 0) {
        if (a < b) swap(a, b);
        if (a < c) swap(a, c);
        if (a * a == b * b + c * c) {
            cout << "right" << endl;
        } else {
            cout << "wrong" << endl;
        }
        cin >> a >> b >> c;
    }
}