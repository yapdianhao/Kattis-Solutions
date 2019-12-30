class TrollHunt {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int b = io.getInt();
        int k = io.getInt();
        int m = io.getInt();
        b--;
        double g = k / m;
        double x = b / g;
        io.println((int)Math.ceil(x));
        io.close();
    }
}