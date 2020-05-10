import java.util.HashSet;

class Patuljci {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int[] arr = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = io.getInt();
            total += arr[i];
        }
        int remain = total - 100;
        HashSet<Integer> hs = new HashSet<>();
        int f = -1;
        int j = -1;
        for (int i : arr) {
            if (!hs.contains(remain - i)) {
                hs.add(i);
            } else {
                j = i;
                f = remain - i;
            }
        }
        for (int i : arr) {
            if (i == f || i == j) continue;
            io.println(i);
        }
        io.close();
    }
}