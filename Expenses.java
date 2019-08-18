import java.util.*;

class Expenses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int expense = sc.nextInt();
            if (expense < 0) {
                total += Math.abs(expense);
            }
        }
        System.out.println(total);
    }
}