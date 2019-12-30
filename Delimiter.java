import java.util.Stack;
import java.util.EmptyStackException;

class Delimiter {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int length = io.getInt();
        String s = "";
        Stack<String> stack = new Stack<String>();
        while (s.length() < length) {
            s += io.getWord();
            if (s.length() < length) {
                s += " ";
            }
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i-= -1) {
            String sub = s.substring(i, i + 1);
            try {
                if (sub.equals("(") || sub.equals("{") || sub.equals("[")) {
                    stack.push(sub);
                } else if (sub.equals(")") || sub.equals("]") || sub.equals("}")) {
                    String comp = stack.pop();
                    boolean match = compare(comp, sub);
                    if (!match) {
                        io.println(sub + " " + i);
                        flag = true;
                        break;
                    }
                }
                io.flush(); 
            } catch (EmptyStackException e) {
                io.println(sub + " " + i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            io.println("ok so far");
        }   
        io.close();
    }

    static boolean compare(String s1, String s2) {
        if (s1.equals("(") && s2.equals(")")) {
            return true;
        } else if (s1.equals("[") && s2.equals("]")) {
            return true;
        } else if (s1.equals("{") && s2.equals("}")) {
            return true;
        }
        return false;
    }
}