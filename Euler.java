class Euler {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        double n = io.getInt();
        io.println(euler(n));
        io.close();
    }

    static double fact(double n) {
        return (n == 0 ? 1 : n * fact(n - 1));
    }

    static double euler(double n) {
        if (n == 0) {
            return 1;
        } else {
            return 1 / fact(n) + euler(n - 1);
        }
    }
}