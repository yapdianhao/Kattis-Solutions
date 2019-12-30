import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

class DataStructure {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        while (io.hasMoreTokens()) {
            int in = io.getInt();
            boolean ispq = true;
            boolean isq = true;
            boolean iss = true;
            PriorityQueue<Integer> pq = new PriorityQueue<>(in, Collections.reverseOrder());
            Stack<Integer> s = new Stack<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < in; i++) {
                int cmd = io.getInt();
                int res = io.getInt();
                if (cmd == 1) {
                    pq.add(res);
                    q.add(res);
                    s.add(res);
                } else {
                    try {
                        int frompq = pq.poll();
                        int fromq = q.poll();
                        int froms = s.pop();
                        if (frompq != res) ispq = false;
                        if (fromq != res) isq = false;
                        if (froms != res) iss = false;
                    } catch(Exception e) {
                        io.println("impossible");
                        io.close();
                        return;
                    }
                }
            }
            if (ispq && !isq && !iss) io.println("priority queue");
            else if (isq && !ispq && !iss) io.println("queue");
            else if (iss && !ispq && !isq) io.println("stack");
            else if (!ispq && !isq && !iss) io.println("impossible");
            else io.println("not sure");
        }
        io.close();
    }
}