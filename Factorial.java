import java.util.*;

class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int[] arr = new int[cases];
        for (int i = 0; i < cases; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            int fac = factorial(i);
            String string = "" + fac;
            System.out.println(string.charAt(string.length() - 1));
        }
    }

    static int factorial(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
}