#include <iostream>
#include <string>

using namespace std;

int main() {
    int capacity;
    int lines;
    int curr = 0;
    int rejected = 0;
    cin >> capacity >> lines;
    for (int i = 0; i < lines; i++) {
        string header;
        int size;
        cin >> header >> size;
        if (header == "enter") {
            if (curr + size > capacity) rejected++;
            else curr += size;
        } else {
            curr -= size;
        }
    }
    cout << rejected << endl;
}