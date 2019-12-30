import java.util.Hashtable;

class Recount {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        String s = io.getLine();
        while (!s.equals("***")) {
            if (ht.containsKey(s)) {
                ht.put(s, ht.get(s) + 1);
            } else {
                ht.put(s, 0);
            }
            s = io.getLine();
        }
        int max = 0;
        String curr = "";
        for (String temp : ht.keySet()) {
            if (ht.get(temp) > max) {
                max = ht.get(temp);
                curr = temp;
            }
        }
        int count = 0;
        for (int temp : ht.values()) {
            if (temp == max && count == 0) {
                count++;
            } else if (temp == max && count > 0) {
                io.println("Runoff!");
                io.close();
                return;
            }
        }
        io.println(curr);
        io.close();
    }
}