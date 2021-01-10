#include <iostream>
#include <stack>

using namespace std;

int main() {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        arr[i] = x;
    }
    for (int i = n - 1; i >= 0; i--) {
        cout << arr[i] << endl;
    }
}