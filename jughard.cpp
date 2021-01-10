#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        long long a, b, c;
        cin >> a >> b >> c;
        long long g = __gcd(a, b);
        if (c % g == 0) {
            cout << "Yes" << endl;
        } else {
            cout << "No" << endl;
        }
    }
}