import java.util.Stack;

public class Rseq3 {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        //Kattio io = new Kattio(System.in);
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int t = io.getInt();
        String[] arr = io.getWord().split("/");
        int d = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        int x = calc(d, n) + 1;
        Stack<Integer> s = new Stack<>();
        int p = 1;
        int q = 1;
        while (x > 0) {
            if (x != 1) s.add(x);
            x /= 2;
        }
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (curr % 2 == 0) {
                q += p;
            } else {
                p += q;
            }
        }
        io.println(t + " " + p + "/" + q);
    }

    static int calc(int d, int n) {
        if (d == n) {
            return 1;
        } else {
            System.out.println(d + " " + n);
            if (d > n) {
                return 2 * (calc(d - n, n)) + 1;
            } else {
                return 2 * (calc(d, n - d));
            }
        }
    }
}