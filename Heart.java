class Heart {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int cases = io.getInt();
        while (cases-- > 0) {
            solve(io);
        }
        io.close();
    }

    static void solve(Kattio io) {
        double d1 = io.getDouble();
        double d2 = io.getDouble();
        d1 = 60 * (d1 / d2);
        d2 = 60 / d2;
        io.println(d1 - d2 + " " + d1 + " " + (d1 + d2));
    } 
}