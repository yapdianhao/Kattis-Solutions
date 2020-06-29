#include <iostream>
#include <vector>

using namespace std;

int main() {
    cout.precision(6);
    int n;
    cin >> n;
    vector<int> x_axis;
    vector<double> y_axis;
    double total = 0;
    for (int i = 0; i < n; i++) {
        int x;
        double y;
        cin >> x >> y;
        x_axis.push_back(x);
        y_axis.push_back(y);
    }
    for (int i = 1; i < n; i++) {
        double area = (x_axis[i] - x_axis[i - 1]) * (y_axis[i] + y_axis[i - 1]) / 2;
        total += area / 1000;
    }
    printf("%.6f\n", total);
}