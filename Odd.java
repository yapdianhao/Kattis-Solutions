import java.util.Hashtable;

class Odd {
    static Kattio io = new Kattio(System.in);
    public static void main(String[] args) {
        int c = io.getInt();
        for (int i = 0; i < c; i++) {
            solve(i + 1);
        }
        io.close();
    }

    /*static void solve(int x) {
        Hashtable<Integer, Integer> h = new Hashtable<>();
        int n = io.getInt();
        for (int j = 0; j < n; j++) {
            int curr = io.getInt();
            if (!h.containsKey(curr)) h.put(curr, 1);
            else h.put(curr, h.get(curr) + 1);
        }
        for (int i : h.keySet()) {
            if (h.get(i) == 1) {
                io.println("Case #" + x + ": " + i);
                break;
            }
        }
    }*/
}