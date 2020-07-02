#include <iostream>

using namespace std;

int main() {
    int a, b, c, n;
    cin >> a >> b >> c >> n;
    if (a == 0 || b == 0 || c == 0 || n < 3) {
        cout << "NO" << endl;
    } else {
        if (a + b + c >= n) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
}