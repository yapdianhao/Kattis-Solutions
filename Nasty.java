class Nasty {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int f = io.getInt();
        int s = io.getInt();
        int r = io.getInt();
        if (s - r < f) {
            io.println("do not advertise");
        } else if (s - r > f) {
            io.println("advertise");
        } else {
            io.println("does not matter");
        }
    }
}