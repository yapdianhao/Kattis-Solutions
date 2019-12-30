class Harshad {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        io.println(gen(n));
        io.close();
    }

    static boolean h(int n) {
        char[] arr = (n + "").toCharArray();
        int temp = 0;
        for (char c : arr) {
            temp += Character.getNumericValue(c);
        }
        return n % temp == 0;
    }

    static int gen(int n) {
        if (h(n)) return n;
        else return gen(n + 1);
    }
}