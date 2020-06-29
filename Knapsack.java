import java.util.*;

class Knapsack {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        while (io.hasMoreTokens()) {
            int W = io.getInt();
            int n = io.getInt();
            solve(W, n);
        }
    }

    static void solve(int W, int n) {
        int[][] T = new int[n + 1][W + 1];
        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = io.getInt();
            w[i] = io.getInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j >= w[i - 1]) {
                    T[i][j] = Math.max(T[i - 1][j - w[i - 1]] + v[i - 1], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        List<Integer> items = new ArrayList<>();
        getItems(T, n, W, v, w, items);
        // io.println(Arrays.toString(w));
        // io.println(Arrays.toString(v));
        // for (int i = 0; i < T.length; i++) {
        // io.println(Arrays.toString(T[i]));
        // }
        io.println(items.size());
        for (int i = 0; i < items.size(); i++) {
            io.print(items.get(i) + " ");
            if (i == items.size() - 1) {
                io.println();
            }
        }
        io.flush();
    }

    static void getItems(int[][] T, int i, int j, int[] v, int[] w, List<Integer> items) {
        if (T[i][j] == 0)
            return;
        else {
            if (T[i][j] == T[i - 1][j]) {
                getItems(T, i - 1, j, v, w, items);
            } else {
                items.add(i - 1);
                getItems(T, i - 1, j - w[i - 1], v, w, items);
            }
        }
    }
}