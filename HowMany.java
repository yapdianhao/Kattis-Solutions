import java.math.BigInteger;

class HowMany {

    static Kattio io = new Kattio(System.in);
    static double[] arr = new double[1000001];

    public static void main(String[] args) {
        for (int i = 1; i <= 1000000; i++) {
            arr[i] = Math.log10(i) + arr[i - 1];
        }
        arr[0] = arr[1] = 1;
        while (io.hasMoreTokens()) {
            solve();
            io.flush();
        }
        io.close();
    }

    static void solve() {
        io.println((int) Math.ceil(arr[io.getInt()]));
    }
}