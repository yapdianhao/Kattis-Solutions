import java.util.Set;
import java.util.Hashtable;
import java.util.HashSet;

class Conformity {

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int t = io.getInt();
        Hashtable<Set<Integer>, Integer> ht = new Hashtable<>();
        for (int i = 0; i < t; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 5; j++) {
                set.add(io.getInt());
            }
            if (ht.containsKey(set)) {
                ht.put(set, ht.get(set) + 1);
            } else {
                ht.put(set, 1);
            }
        }
        int max = 0;
        for (Set s : ht.keySet()) {
            if (ht.get(s) > max) {
                max = ht.get(s);
            }
        }
        int count = 0;
        for (Set s : ht.keySet()) {
            if (ht.get(s) == max) {
                count += ht.get(s);
            }
        }
        io.println(count);
        io.close();
    }
}