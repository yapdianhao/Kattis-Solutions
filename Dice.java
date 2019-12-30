import java.util.Hashtable;

class Dice {

    static Kattio io = new Kattio(System.in);
    public static void main(String[] args) {
        int f1 = io.getInt();
        int f2 = io.getInt();
        int max = 0;
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        for (int i = 1; i <= f1; i++) {
            for (int j = 1; j <= f2; j++) {
                if (!hash.contains(i + j)) {
                    hash.put(i + j, 1);
                    max = Math.max(max, hash.get(i + j));
                } else {
                    hash.put(i + j, hash.get(i + j) + 1);
                    max = Math.max(max, hash.get(i + j));
                }
            }
        }
        io.println(max + "?");
        for (int i : hash.keySet()) {
            if (hash.get(i) == max) {
                io.println(i);
            }
        }
        io.println(hash);
        io.close();
    }
}