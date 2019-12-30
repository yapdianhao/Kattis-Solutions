import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Backspace {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String word = io.getWord();
        Stack<Character> s = new Stack<>();
        for (char c : word.toCharArray()) {
            if (c == '<') {
                s.pop();
            } else {
                s.push(c);
            }
        }
        Queue<Character> q = new LinkedList<Character>(s);
        while (!q.isEmpty()) {
            io.print(q.poll());
        }
        io.close();
    }
}