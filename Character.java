import java.math.BigInteger;

class Character {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int n = io.getInt();
        BigInteger bg = new BigInteger("0");
        for (int i = 2; i <= n; i++) {
            //io.println(nCr(n, i));
            bg = bg.add(nCr(n, i));
        }
        io.println(bg);
        //io.println(fact(3));
        io.close();
    }

    static BigInteger fact(int n) {
        if (n <= 1) return new BigInteger("1");
        else {
            return new BigInteger(n + "").multiply(fact(n - 1));
        }
    }

    static BigInteger nCr(int n, int r) {
        BigInteger num = fact(n);
        BigInteger den1 = fact(r);
        BigInteger den2 = fact(n - r);
        return num.divide(den1.multiply(den2));
    }
}