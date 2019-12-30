import java.util.*;

class Zoo {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int n = io.getInt();
        int c = 1;
        while (n != 0) {
            solve(c, n);
            c++;
            n = io.getInt();
        }
        io.close();
    }

    static void solve(int c, int n) {
        HashMap<String, Integer> h = new HashMap<>();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = io.getLine().toLowerCase().split(" ");
            String name = arr[arr.length - 1];
            if (!h.containsKey(name)) {
                lst.add(name);
                h.put(name, 1);
            } else {
                h.put(name, h.get(name) + 1);
            }
        }
        Collections.sort(lst);
        io.println("List " + c + ":");
        for (String s : lst) {
            io.println(s + " | " + h.get(s));
        }
    }
}