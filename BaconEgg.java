import java.util.*;

class BaconEgg {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int in = io.getInt();
        while (in != 0) {
            solve(in);
            io.println();
            in = io.getInt();
        }
        io.close();
    }

    static void solve(int in) {
        Hashtable<String, List<String>> ht = new Hashtable<>();
        List<String> food = new ArrayList<String>();
        for (int i = 0; i < in; i++) {
            String[] line = io.getLine().split(" ");
            for (int j = 1; j < line.length; j++) {
                if (!ht.containsKey(line[j])) {
                    List<String> names = new ArrayList<>();
                    names.add(line[0]);
                    food.add(line[j]);
                    ht.put(line[j], names);
                } else {
                    ht.get(line[j]).add(line[0]);
                }
            }
        }
        Collections.sort(food);
        for (String s : food) {
            StringBuilder sb = new StringBuilder();
            sb.append(s + " ");
            Collections.sort(ht.get(s));
            for (String name : ht.get(s)) {
                sb.append(name + " ");
            }
            io.println(sb.toString());
        }
    }
}