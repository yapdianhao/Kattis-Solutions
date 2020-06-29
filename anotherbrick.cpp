#include <iostream>
#include <vector>

using namespace std;

int main() {
    int h, w, n;
    cin >> h >> w >> n;
    vector<int> vc;
    for (int i = 0; i < n; i++) {
        int curr;
        cin >> curr;
        vc.push_back(curr);
    }
    int currLayer = 0;
    for (int i = 0; i < n; i++) {
        currLayer += vc[i];
        if (currLayer == w) {
            currLayer = 0;
            h--;
        } else if (currLayer > w) {
            cout << "NO" << endl;
            return 0;
        }
        if (h == 0) break;
    }
    if (h == 0) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}