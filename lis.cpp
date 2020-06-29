#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    while (true) {
        int n;
        cin >> n;
        vector<int> arr;
        for (int i = 0; i < n; i++) {
            int curr;
            cin >> curr;
            arr.push_back(curr);
        }
        vector<int> table;
        for (int i = 0; i < n; i++) {
            table.push_back(1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    table[i] = max(table[i], table[j] + 1);
                }
                if (table[i] > ans) {
                    ans = table[i];
                }
            }
        }
        cout << ans << endl;
        vector<int> output;
        if (ans == 1) {
            cout << 0 << endl;
            continue;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (ans == 0) {
                cout << endl;
                break;
            }
            if (table[i] == ans) {
                output.push_back(i);
                ans -= 1;
            } 
        }
        for (int i = output.size() - 1; i >= 0; i--) {
            cout << output[i] << " ";
            if (i == 0) cout << endl;
        }
    }
}