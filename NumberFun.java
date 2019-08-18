import java.util.*;

class NumberFun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int first = sc.nextInt();
            int sec = sc.nextInt();
            int res = sc.nextInt();
            if (add(first, sec, res) || subtract(first, sec, res) || multiply(first, sec, res) || divide(first, sec, res)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    static boolean add(int first, int sec, int res) {
        return (first + sec) == res;
    }

    static boolean multiply(int first, int sec, int res) {
        return (first * sec) == res;
    }

    static boolean subtract(int first, int sec, int res) {
        return (first - sec) == res || (sec - first) == res;
    }

    static boolean divide(int first, int sec, int res) {
        if ((first % sec == 0) || (sec % first == 0)) {
            return (first / sec) == res || (sec / first) == res;
        } else {
            return false;
        }
    }
}