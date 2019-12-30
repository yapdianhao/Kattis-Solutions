class RSeq2 {
    
    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int t = io.getInt();
        String[] arr = io.getWord().split("/");
        int d = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        int x = calc(d, n);
        io.println(t + " "  + x);
    }

    static int calc(int d, int n) {
        if (d == n) {
            return 1;
        } else {
            if (d > n) {
                return 2 * (calc(d - n, n)) + 1;
            } else {
                return 2 * (calc(d, n - d));
            }
        }
    }
}