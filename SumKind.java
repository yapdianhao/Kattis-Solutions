class SumKind {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int test = io.getInt();
        int n = io.getInt();
        int sum = gen(n);
        int odd = genOdd(n);
        int even = genEven(n);
        io.println(test + " " + sum + " " + odd + " " + even);
    }

    static int gen(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += i;
        }
        return res;
    }

    static int genOdd(int n) {
        int res = 0;
        int count = 0;
        while (n > 0) {
            if (count % 2 == 1) {
                res += count;
                n--;
            }
            count++;
        }
        return res;
    }

    static int genEven(int n) {
        int res = 0;
        int count = 2;
        while (n > 0) {
            if (count % 2 == 0) {
                res += count;
                n--;
            }
            count++;
        }
        return res;
    }
}