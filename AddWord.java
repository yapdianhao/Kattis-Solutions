import java.util.Hashtable;
import java.util.Queue;
import java.util.LinkedList;

class AddWord {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        Hashtable<String, Integer> h = new Hashtable<>();
        while (io.hasMoreTokens()) {
            String line = io.getLine();
            if (line.equals("clear")) h.clear();
            else {
                String[] words = line.split(" ");
                if (words[0].equals("def")) {
                    h.put(words[1], Integer.parseInt(words[2]));
                } else {
                    int curr = 0; 
                    for (int i = 1; i < words.length; i += 2) {
                        if (!h.containsKey(words[i])) {
                            io.println(line.substring(5) + " unknown");
                            break;
                        }
                    }
                    curr = h.get(words[0]);
                    Queue<String> q = new LinkedList<>();
                    for (int i = 2; i < words.length - 1; i++) {
                        q.add(words[i]);
                    }
                    while (!q.isEmpty()) {
                        String op = q.poll();
                        if (op.equals("+")) {
                            curr += h.get(q.poll());
                        } else {
                            curr -= h.get(q.poll());
                        }
                    }
                    if (!h.containsKey(curr)) io.println(line.substring(5) + " unknown");
                    else {
                        for (String s : h.keySet()) {
                            if (ht.get(s) == curr) io.println(line.substring(5) + " " + s);
                        }
                    }
                }
            }
        }
        io.close();
    }
}