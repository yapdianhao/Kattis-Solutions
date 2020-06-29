#include <iostream>
#include <vector>

using namespace std;

int main() {

    int n;
    cin >> n;

    vector<int> vc (n + 1);

    for (int i = 0; i < n; i++) {
        int curr;
        cin >> curr;
        if (vc[curr] != 0) vc[curr]--;
        vc[curr - 1]++;
    }
    
    int total = 0;
    for (int i = 0; i <= n; i++) {
        total += vc[i];
    }
    cout << total << endl;
}