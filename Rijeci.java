class Rijeci {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int n = io.getInt();
        Pair start = new Pair(1, 0);
        while (n-- > 0) {
            start = calc(start);
        }
        io.println(start.x + " " + start.y);
        io.close();
    }

    static Pair calc(Pair start) {
        int temp = start.y;
        start.y += start.x;
        start.x = temp;
        return start;
    }

    static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}