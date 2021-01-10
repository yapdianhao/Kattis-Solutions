#include <iostream>

using namespace std;

int main() {
    string input;
    cin >> input;
    string start = "0";
    string end = "0";
    bool seen = false;
    int ans = 0;
    for (int i = 0; i < input.size(); i++) {
        if (input[i] == ';') {
            int range = stoi(end) - stoi(start);
            ans += (range < 0 ? 1 : range + 1);
            start = "0";
            end = "0";
            seen = false;
        } else if (input[i] == '-') {
            seen = true;
        } else if (!seen) {
            start += input[i];
        } else if (seen) {
            end += input[i];
        }
    }
    int range = stoi(end) - stoi(start);
    ans += (range < 0 ? 1 : range + 1);
    cout << ans << endl;
}