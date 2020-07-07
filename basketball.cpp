#include <iostream>
#include <string>

using namespace std;

int main() {
    string input;
    cin >> input;
    int count = 0;
    char curr = 'C';
    int ascore = 0;
    int bscore = 0;
    char tie = 'C';
    bool flag = false;
    for (int i = 0; i < input.size(); i++) {
        if (count % 2 != 0) {
            if (curr == 'A') {
                ascore += input[i] - '0';
            } else {
                bscore += input[i] - '0';
            }
        } else {
            curr = input[i];
        }
        count += 1;
        if (ascore == bscore + 2 && !flag) {
            tie = 'A';
            flag = true;
        }
        if (bscore == ascore + 2 && !flag) {
            tie = 'B';
            flag = true;
        }
    }
    if (ascore > bscore) {
        cout << 'A' << endl;
    } else if (ascore < bscore) {
        cout << 'B' << endl;
    } else {
        cout << tie << endl;
    }
}