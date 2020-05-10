import java.util.Stack;

class PairSock {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        Stack<Integer> s1  = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        for (int i = 0; i < 2 * n; i++) {
            s3.push(io.getInt());
        }
        while (!s3.isEmpty()) {
            s1.push(s3.pop());
        }
        long m = 0;
        while (!s1.isEmpty()) {
            //io.print(s1);
            //io.println(" " + s2);
            m++;
            if (s2.isEmpty()) {
                s2.push(s1.pop());
                continue;
            } 
            int a = s1.peek();
            int b = s2.peek();
            //io.println(s1.peek() + " " + s2.peek());
            if (a == b) {
                s1.pop();
                s2.pop();
                continue;
            }
            s2.push(s1.pop());
        }
        if (s2.isEmpty()) io.println(m);
        else io.println("impossible");
        io.close();
    }
}