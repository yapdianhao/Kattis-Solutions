#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    int size;
    cin >> size;
    vector<int> vec;
    for (int i = 0; i < size; i++) {
        int curr;
        cin >> curr;
        vec.push_back(curr);
    }
    long long total = 0;
    sort(vec.begin(), vec.end(), greater<int>());
    for (int i = 0; i < size; i++) {
        if ((i + 1) % 3 == 0) {
            total += vec[i];
        }
    }
    cout << total << endl;
}