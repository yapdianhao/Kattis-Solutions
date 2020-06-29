#include <iostream>
using namespace std;

void solve(int);

int main() {
    int l;
    cin >> l;
    while (l != -1) {
        solve(l);
        cin >> l;
    }
}

void solve(int l) {
    int speed[l];
    int hours[l];
    int total = 0;
    for (int i = 0; i < l; i++) {
        cin >> speed[i] >> hours[i];
    }
    for (int i = 1; i < l; i++) {
        total += (hours[i] - hours[i - 1]) * speed[i];
    }
    total += speed[0] * hours[0];
    cout << total << " miles" << endl;
}