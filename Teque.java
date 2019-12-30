import java.util.Queue;
import java.util.LinkedList;

class Teque {

    static Kattio io = new Kattio(System.in);
    static LinkedList<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        int cmd = io.getInt();
        for (int i = 0; i < cmd; i++) {
            String s = io.getWord();
            int n = io.getInt();
            if (s.equals("push_back")) {
                q.addLast(n);
            } else if (s.equals("push_front")) {
                q.addFirst(n);
            } else if (s.equals("push_middle")) {
                q.add((q.size() + 1) / 2, n);
            } else if (s.equals("get")) {
                io.println(q.get(n));
            }
        }
        io.close();
    }
}