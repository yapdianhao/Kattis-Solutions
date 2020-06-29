#include <iostream>
using namespace std;

int main() {
    int lines;
    cin >> lines;
    cout.precision(10);
    int seconds[lines];
    int minutes[lines];
    for (int i = 0; i < lines; i++) {
        cin >> minutes[i] >> seconds[i];
    }
    double total = 0;
    int sum = 0;
    for (int i = 0; i < lines; i++) {
        double curr = seconds[i] / 60.0;
        //cout << curr << " " << total << " ";
        total += curr;
        sum += minutes[i];
    }
    total /= sum;
    if (total > 1) {
        cout << total << endl;
    } else {
        cout << "measurement error" << endl;
    }
}