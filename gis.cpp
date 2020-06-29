#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> t;
    vector<int> v;
    for (int i = 0; i < n; i++) {
        int curr;
        cin >> curr;
        t.push_back(curr);
    }
    int count = 0;
    int seen = 0;
    for (int i = 0; i < n; i++) {
        if (t[i] > seen) {
            v.push_back(t[i]);
            seen = t[i];
        }
    }
    cout << v.size() << endl;
    for (int i = 0; i < v.size(); i++) {
        if (i == v.size() - 1) {
            cout << v[i] << endl;
        } else {
            cout << v[i] << " ";
        }
    }
}