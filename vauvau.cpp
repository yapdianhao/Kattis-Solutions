#include <iostream>

using namespace std;



int main() {
    int Aa, Ca, Ab, Cb;
    cin >> Aa >> Ca >> Ab >> Cb;
    int aggr_a = Aa;
    int calm_a = Ca;    
    int aggr_b = Ab;
    int calm_b = Cb;
    int postman;
    int milkman;
    int garbageman;
    cin >> postman >> milkman >> garbageman;
    int size = postman;
    size = size > milkman ? size : milkman;
    size = size > garbageman ? size : garbageman;
    bool A[size];
    bool B[size];
    for (int i = 0; i < size; i++) {
        if (aggr_a != 0) {
            A[i] = true;
            aggr_a--;
        } else if (calm_a != 0) {
            A[i] = false;
            calm_a--;
        } else {
            A[i] = true;
            aggr_a = Aa - 1;
            calm_a = Ca;
        }
    }
    for (int i = 0; i < size; i++) {
        if (aggr_b != 0) {
            B[i] = true;
            aggr_b--;
        } else if (calm_b != 0) {
            B[i] = false;
            calm_b--;
        } else {
            B[i] = true;
            aggr_b = Ab - 1;
            calm_b = Cb;
        }
    }
    bool statusA = A[postman - 1];
    bool statusB = B[postman - 1];
    if (statusA && statusB) {
        cout << "both" << endl;
    } else if (statusA || statusB) {
        cout << "one" << endl;
    } else {
         cout << "none" << endl;
    }
    statusA = A[milkman - 1];
    statusB = B[milkman - 1];
    if (statusA && statusB) {
        cout << "both" << endl;
    } else if (statusA || statusB) {
        cout << "one" << endl;
    } else {
         cout << "none" << endl;
    }
    statusA = A[garbageman - 1];
    statusB = B[garbageman - 1];
    if (statusA && statusB) {
        cout << "both" << endl;
    } else if (statusA || statusB) {
        cout << "one" << endl;
    } else {
         cout << "none" << endl;
    }
}