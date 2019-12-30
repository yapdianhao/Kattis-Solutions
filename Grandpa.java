import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.Collections;

class Grandpa {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        long trips = io.getLong();
        Hashtable<String, List<Long>> ht = new Hashtable<String, List<Long>>();
        //Hashtable<String, Boolean> check = new Hashtable<String, Boolean>();
        for (int i = 0; i < trips; i++) {
            String c = io.getWord();
            long year = io.getLong();
            if (!ht.containsKey(c)) {
                ht.put(c, new ArrayList<Long>());
                ht.get(c).add(year);
                //check.put(c, false);
            } else {
                ht.get(c).add(year);
            }
        }
        for (String c : ht.keySet()) {
            Collections.sort(ht.get(c));
        }
        long q = io.getLong();
        for (int i = 0; i < q; i++) {
            String c = io.getWord();
            long y = io.getLong();
            io.println(ht.get(c).get((int)y - 1));
        }
        io.close();
    }
}