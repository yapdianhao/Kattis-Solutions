import java.util.*;

class Different {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long first = sc.nextLong();
            long sec = sc.nextLong();
            System.out.println(Math.abs(first - sec));
        }
    }
}
