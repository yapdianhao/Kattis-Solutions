#include <iostream>

using namespace std;

int main() {
    int left, mid, right;
    cin >> left >> mid >> right;
    int moves = 0;
    while (mid - left > 1 || right - mid > 1) {
        int between;
        if (mid - left == 1) {
            between = right - 1;
            left = mid;
            mid = between;
        } else if (right - mid == 1) {
            between = left + 1;
            right = mid;
            mid = between;
        } else {
            if (right - mid > mid - left) {
                between = right - 1;
                left = mid;
                mid = between;
            } else {
                between = left + 1;
                right = mid;
                mid = between;
            }
        }
        moves++;
        //cout << left << " " << mid << " " << right << endl;
    }
    cout << moves << endl;
}