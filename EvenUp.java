import java.util.Stack;

class EvenUp {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int num = io.getInt();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < num; i++) {
            int curr = io.getInt();
            if (s.isEmpty()) {
                s.add(curr);
            } else {
                int last = s.peek();
                if ((last + curr) % 2 == 0) {
                    s.pop();
                } else {
                    s.add(curr);
                }
            }
        }
        io.println(s.size());
        io.close();
    }
}