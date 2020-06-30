#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int testCases;
    cin >> testCases;
    for (int i = 0; i < testCases; i++) {
        int shops;
        cin >> shops;
        int arr[shops];
        for (int j = 0; j < shops; j++) {
            cin >> arr[j];
        }
        sort(arr, arr + shops);
        int mid = (arr[0] + arr[shops - 1]) / 2;
        int dist = mid - arr[0];
        for (int j = 1; j < shops; j++) {
            dist += arr[j] - arr[j - 1];
        }
        dist += arr[shops - 1] - mid;
        cout << dist << endl;
    }
}