#include <iostream>

using namespace std;

int main() {
    string s;
    cin >> s;
    int e = 0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == 'e') e++;
    }
    string ans = "h";
    for (int i = 0; i < e * 2; i++) {
        ans += "e";
    }
    ans += "y";
    cout << ans << endl;
}