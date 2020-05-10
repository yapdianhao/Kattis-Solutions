import java.util.*;

class Candy {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        Kattio io = new Kattio(System.in);
        TreeSet<Long> lst = new TreeSet<>();
        long n = io.getLong();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                lst.add((long) i);
                lst.add((long) n / i);
                //s.push((int) n / i);
            }
        }
        while (!lst.isEmpty()) {
            io.print(lst.pollFirst() - 1 + " ");
        }
        /*while(!s.isEmpty()) {
            io.print(s.pop() - 1 + " ");
        }*/
        io.println();
        io.close();
    }
}