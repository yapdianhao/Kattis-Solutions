import java.util.*;

class TwoStones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        if (next % 2 == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }
}