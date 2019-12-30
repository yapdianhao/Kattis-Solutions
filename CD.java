import java.util.LinkedList;
import java.util.Queue;

class CD {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int jack = io.getInt();
        int jill = io.getInt();
        while (jack != 0 || jill != 0) {
            solve(jack, jill);
            jack = io.getInt();
            jill = io.getInt();
        }
        io.close();
    }

    static void solve(int jack, int jill) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < jack; i++) {
            q1.add(io.getInt());
        }
        for (int i = 0; i < jill; i++) {
            q2.add(io.getInt());
        }
        int c = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int curr1 = q1.peek();
            int curr2 = q2.peek();
            if (curr1 == curr2) {
                c++;
                q1.poll();
                q2.poll();
            } else if (curr1 < curr2) {
                q1.poll();
            } else if (curr2 < curr1) {
                q2.poll();
            }
        }
        io.println(c);
    }
}