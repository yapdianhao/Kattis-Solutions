class PrimeSieve {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int num = io.getInt();
        int cases = io.getInt();
        int ct = 0;
        for (int i = 2; i < num + 1; i++) {
            if (isPrime(i)) ct++;
        }
        io.println(ct);
        for (int i = 0; i < cases; i++) {
            int curr = io.getInt();
            io.println(isPrime(curr) ? 1 : 0);
        }
        io.close();
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


}