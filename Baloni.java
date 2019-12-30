import java.util.HashSet;

class Baloni {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int balloons = io.getInt();
        HashSet<Integer> hash = new HashSet<>();
        int[] arr = new int[balloons];
        for (int i = 0; i < balloons; i++) {
            arr[i] = io.getInt();
        }
        int r = 0;
        for (int i : arr) {
            if (!hash.contains(i + 1)) {
                r++;
            }
            hash.add(i);
        }
        io.println(r);
        io.close();
    }
}