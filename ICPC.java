import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

class ICPC {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        io.println();
        int t = io.getInt();
        Hashtable<String, String> ht = new Hashtable<>();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String u = io.getWord();
            String v = io.getWord();
            if (!ht.containsKey(u)) {
                ht.put(u, v);
                lst.add(u);
            }
            if (ht.size() == 12) break;
        }
        for (String temp : lst) {
            io.println(temp + " " + ht.get(temp));
        }
        io.close();
    }
}