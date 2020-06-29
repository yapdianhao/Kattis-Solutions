#include <iostream>

using namespace std;

int main() {
    long long l, n;
    cin >> l >> n;
    long long ans = 1;
    while (l % n != 0) {
        n -= l % n;
        ans++;
    }
    cout << ans << endl;
}