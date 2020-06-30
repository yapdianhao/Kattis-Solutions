#include <iostream>

using namespace std;

int main() {

    int start, end, stops;
    cin >> start >> end >> stops;
    int startToFirst, lastToEnd;
    int run[stops - 1];
    cin >> startToFirst;
    for (int i = 0; i < stops - 1; i++) {
        cin >> run[i];
    }
    cin >> lastToEnd;
    int ride[stops];
    int arrive[stops];
    for (int i = 0; i < stops; i++) {
      cin >> ride[i];
    }
    for (int i = 0; i < stops; i++) {
      cin >> arrive[i];
    }
    start += startToFirst;
    for (int i = 0; i < stops; i++) {
      if (start % arrive[i] != 0) {
        int temp = start / arrive[i];
        start = arrive[i] * (temp + 1);
      }
      start += ride[i];
      if (i != stops - 1) {
        start += run[i];
      }
      //cout << start << endl;
    }
    start += lastToEnd;
    if (start > end) {
      cout << "no" << endl;
    } else {
      cout << "yes" << endl;
    }
}
