import java.util.PriorityQueue;
import java.util.Stack;

class RSeq {

    static Kattio io = new Kattio(System.in);
    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    } 

    static void solve() {
        int num = io.getInt();
        int n = io.getInt();
        Stack<Integer> s = new Stack<>();
        int p = 1;
        int q = 1;
        while (n > 0) {
            if (n != 1) s.add(n);
            n /= 2;
        }
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (curr % 2 == 0) {
                q += p;
            } else {
                p += q;
            }
        }
        io.println(num + " " + p + "/" + q);
    }
}