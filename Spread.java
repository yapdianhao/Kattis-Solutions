import java.util.*;

class Spread {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in, System.out);
        int cases = kattio.getInt();
        for (int i = 0 ; i < cases; i++) {
            int total = kattio.getInt();
            int diff = kattio.getInt();
            int ans = solve(total, diff);
            kattio.println(ans);
        }
        kattio.close();
    }

    static int solve(int total, int diff) {
        for (int i = 0; i < 1000; i++) {
            System.out.println("TOTAL: " + addCorrect(i, total));
            System.out.println("DIFF: " + diffCorrect(i, diff));
            if (addCorrect(i, total) + i == total && Math.abs(diffCorrect(i, diff)) == diff) {
                return i;
            }
        }
        return -1;
    }

    static int addCorrect(int i , int total) {
        int MAX = 1000;
        int MIN = 0;
        while (MIN < MAX) {
            int mid = (MAX + MIN) / 2;
            if ((mid + i) > total) {
                MAX = mid;
            } else {
                MIN = mid + 1;
            }
        }
        return MIN;
    }

    static int diffCorrect(int i, int diff) {
        int MAX = 1000;
        int MIN = 0;
        while (MIN < MAX) {
            int mid = (MIN + MAX) / 2;
            if ((mid - i) > diff) {
                MAX = mid;
            } else {
                MIN = mid + 1;
            }
        }
        return MIN;
    }
}