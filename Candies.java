import java.util.*;

class Candies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int kids = sc.nextInt();
            long sum = 0;
            for (int j = 0; j < kids; j++) {
                sum += sc.nextLong() % kids;
            }
            System.out.println(sum % kids == 0 ? "YES" : "NO");
        }
    }
}