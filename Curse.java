import java.util.Arrays;

class Curse {
    
    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        double x = io.getDouble();
        double y = io.getDouble();
        int candles = io.getInt();
        double[] xarr = new double[candles];
        double[] yarr = new double[candles];
        for (int i = 0; i < candles; i++) {
            xarr[i] = io.getDouble();
            yarr[i] = io.getDouble();
        }
        for (int i = 0; i < candles; i++) {
            double dist = calc(x, y, xarr[i], yarr[i]);
            if (dist <= 8) {
                io.println("light a candle");
                return;
            }
        }
        io.println("curse the darkness");
    }

    static double calc(double x1, double y1, double x2, double y2) {
        double h = x2 - x1;
        double v = y2 - y1;
        return Math.sqrt(Math.pow(h, 2) + Math.pow(v, 2));
    }
}