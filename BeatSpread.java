class BeatSpread {

    static Kattio io = new Kattio(System.in);
    public static void main(String[] args) {
        int cases = io.getInt();
        while (cases--> 0) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int ts = io.getInt();
        int td = io.getInt();
        if (ts < td) {
            io.println("impossible");
            return;
        }
        if ((ts + td) % 2 == 1) {
            io.println("impossible");
            return;
        }
        int hi = 1000;
        int lo = 0;
        while (lo < hi) {
            //System.out.println(hi + " " + lo);
            if (hi + lo > ts) {
                hi--;
            } else if (hi + lo == ts) {
                if (hi - lo > td) {
                    lo++;
                    hi--;
                } else if (hi - lo == td) {
                    io.print(hi + " " + lo);
                    io.println();
                    return;
                } 
            } else if (hi + lo < ts) {
                lo++;
            }
            //hi--;
            //lo++;
        }
        io.println("impossible");
    }
}