import java.util.Arrays;

class Fib {

    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    static int fib(int n) {
        int[] arr = new int[n + 1];
        if (n < 2) return n;
        else {
            for (int i = 0 ; i <= n; i++) {
                if (i < 2) {
                    arr[i] = i;
                } else {
                    arr[i] = arr[i - 2] + arr[i - 1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }
}