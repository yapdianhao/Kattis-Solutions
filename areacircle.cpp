#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double r;
    int m;
    int c;
    cout.precision(10);
    cin >> r >> m >> c;
    while (r != 0 && m != 0 && c != 0) {
        double areaCircle = M_PI * pow(r, 2);
        double estimate = pow(2 * r, 2) * c / m;
        cout << areaCircle << " " << estimate << endl;
        cin >> r >> m >> c;
    }
}