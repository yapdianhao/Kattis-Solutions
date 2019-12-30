import java.util.Hashtable;

class Lineup {

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(-1, 1);
        for (int i = 1; i < n; i++) {
            ht.put(io.getInt(), i + 1);
        }
        for (int i = -1; i < n - 1; i++) {
            io.print(ht.get(i) + " ");
        }
        io.close();
    }
}