import java.util.HashSet;

class Baloni {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int balloons = io.getInt();
        int[] arr = new int[balloons + 1];
        for (int i = 0; i < balloons; i++) {
            int curr = io.getInt();
            if (arr[curr] == 0) {
                arr[curr - 1]++;
            } else {
                arr[curr - 1]++;
                arr[curr]--;
            }
        }
        int total = 0;
        for (int i = 0; i <= balloons; i++) {
            total += arr[i];
        }
        io.println(total);
        io.close();
    }
}