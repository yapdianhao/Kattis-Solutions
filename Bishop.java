import java.util.*;

class Bishop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long input = sc.nextLong();
            System.out.println(bishop(input));
        }
    }

    static long bishop(long l) {
        if (l == 0 || l == 1) {
            return l;
        } else {
            return 2 * (l - 1);
        }
    }
}

