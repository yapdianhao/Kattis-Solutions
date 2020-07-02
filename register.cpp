#include <iostream>

using namespace std;

bool same(int arr[], int registers[]) {
    for (int i = 0; i < 8; i++) {
        if (arr[i] != registers[i]) return false;
    }
    return true;
}

void increment(int arr[], int registers[], int idx) {
    if (arr[idx] == registers[idx]) {
        arr[idx] = 0;
        increment(arr, registers, idx + 1);
    } else {
        arr[idx] += 1;
    }
}

int main() {
    int registers[8] = {1, 2, 4, 6, 10, 12, 16, 18};
    int arr[8];
    for (int i = 0; i < 8; i++) {
        cin >> arr[i];
    }
    int total = 0;
    while (!same(arr, registers)) {
        total += 1;
        increment(arr, registers, 0);
    }
    cout << total << endl;
}