#include <iostream>
#include <vector>

using namespace std;

int main() {

    int ppl, time;
    cin >> ppl >> time;
    vector<int> queue(time + 1, 0);
    for (int i = 0; i < ppl; i++) {
        int amount, leave;
        cin >> amount >> leave;
        for (int j = leave; j >= 0; j--) {
            if (amount > queue[j]) {
                swap(amount, queue[j]);
            }
        }
    }
    int total = 0;
    for (auto& i : queue) {
        total += i;
    }
    cout << total << endl;
}