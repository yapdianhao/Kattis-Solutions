import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Hardwood {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String s = io.getLine();
        List<String> lst = new ArrayList<String>();
        int count = 0;
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        while (s != null && !s.equals("")) {
            if (!ht.containsKey(s)) {
                ht.put(s, 1);
                lst.add(s);
            } else {
                ht.put(s, ht.get(s) + 1);
            }
            count++;
            s = io.getLine();
        }
        Collections.sort(lst);
        for (String temp : lst) {
            double pc = (double) ht.get(temp) / count;
            io.println(temp + " " + pc * 100);
        }
        //io.println(ht);
        //io.println(count);
        io.close();
    }
}