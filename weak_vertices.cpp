#include <iostream>
#include <vector>

using namespace std;


int main() {
    int n;
    cin >> n;
    while (n != -1) {
        vector<vector<int> > arr(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr;
                cin >> curr;
                arr[i].push_back(curr);
            }
        }
        for (int i = 0; i < n; i++) {
            bool weak = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[i][j] == 1 && arr[i][k] == 1 && arr[j][k] == 1 && i != j && i != k && j != k) {
                        weak = false;
                    }
                }
            }
            if (weak) cout << i << " ";
        }
        cout << endl;
        cin >> n;
    }
}

