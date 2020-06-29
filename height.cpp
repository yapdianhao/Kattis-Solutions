#include <iostream>
#include <vector>

using namespace std;

int main() {
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        vector<int> arr;
        int trash;
        cin >> trash;
        for (int i = 0; i < 20; i++) {
            int curr;
            cin >> curr;
            arr.push_back(curr);
        }
        int total = 0;
        for (int i = arr.size() - 1; i > 0; i--) {
            int max = arr[i];
            int max_idx = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    max_idx = j;
                }
            }
            if (i == max_idx) continue;
            total += i - max_idx;
            int temp = arr[max_idx];
            for (int j = 0; j < i; j++) {
                arr[j] = arr[j + 1];
            }
            arr[i] = temp;
            //cout << i << " " << max_idx << endl;
            //cout << "[";
            //for (int j = 0; j < arr.size(); j++) {
            //    cout << arr[j] << ", ";
            //}
            //cout << "]" << endl;
        }
        cout << trash << " " << total << endl;
    }
}