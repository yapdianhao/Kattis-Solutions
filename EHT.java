import java.util.stream.
*;

class EHT {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int size = kattio.getInt();
        while (size != 0) {
            for (int i = 2 * size; i < Integer.MAX_VALUE; i++) {
                if (isPrime(i) && isPrime(size)) {
                    kattio.println(i);
                    break;
                } else if (isPrime(i) && !isPrime(size)) {
                    kattio.println("" + i + " (" + size + " is not prime)");
                    break;
                }
            }
            size = kattio.getInt();
        }
        kattio.close();
    }

    static boolean isPrime(int n) {
        return IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0);
    }
}