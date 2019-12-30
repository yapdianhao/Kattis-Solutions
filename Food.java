import java.util.HashSet;

class Food {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int days = io.getInt();
        HashSet<Integer> hash = new HashSet<>();
        while (days-- > 0) {
            int start = io.getInt();
            int end = io.getInt();
            for (int i = start; i <= end; i++) {
                if (!hash.contains(i)) hash.add(i);
            }
        }
        io.println(hash.size());
        io.close();
    }
}