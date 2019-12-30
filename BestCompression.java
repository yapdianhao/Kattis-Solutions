import java.util.*;

class BestCompression {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        long file = kattio.getLong();
        long base = kattio.getLong();
        kattio.println(file <= Math.pow(2, base + 1) - 1 ? "yes" : "no");
        kattio.close();
    }
}