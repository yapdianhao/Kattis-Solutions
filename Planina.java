class Planina {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int num = kattio.getInt();
        kattio.println((int)recur(num));
        kattio.close();
    }

    static double recur(int n) {
        if (n == 0) {
            return 2 * 2;
        } else {
            return (2 * Math.sqrt(recur(n - 1)) - 1) * (2 * Math.sqrt(recur(n - 1)) - 1);
        }
    }
}