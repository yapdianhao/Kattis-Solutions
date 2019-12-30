class Easiest {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int curr = io.getInt();
        while (curr != 0) {
            int m = 11;
            int f = gen(curr);
            while (gen(m * curr) != f) {
                m++;
            }
            io.println(m);
            curr = io.getInt();
        }
        io.close();
    }

    static int gen(int n) {
        int res = 0;
        char[] arr = (n + "").toCharArray();
        for (char c : arr) {
            res += Character.getNumericValue(c);
        }
        return res;
    }
}