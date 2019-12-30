class Chanukah {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int c = io.getInt();
        int n = io.getInt();
        int t = 0;
        for (int i = 1; i <= n; i++) {
            t += i;
        }
        io.println(c + " " + (t + n));
    }
}