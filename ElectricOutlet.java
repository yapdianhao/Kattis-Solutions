class ElectricOutlet {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int T = io.getInt();
        while (T-- > 0) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int n = io.getInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += io.getInt();
        }
        io.println(ans - n + 1);
    }
}