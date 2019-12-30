import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class Symmetric {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int strings = io.getInt();
        int x = 1;
        while (strings != 0) {
            solve(strings, x++);
            strings = io.getInt();
        }
        io.close();
    }

    static void solve(int strings, int x) {
        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();
        for (int i = 0; i < strings; i++) {
            if (i % 2 == 0) {
                q.add(io.getWord());
            } else {
                s.add(io.getWord());
            }
        }
        io.println("SET " + x);
        while (!q.isEmpty()) {
            io.println(q.poll());
        }
        while (!s.isEmpty()) {
            io.println(s.pop());
        }
    }
}