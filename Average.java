import java.util.*;

class Average {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in, System.out);
        int cases = kattio.getInt();
        for (int i = 0; i < cases; i++) {
            solve(kattio);
        }
        kattio.close();
    }

    static void solve(Kattio kattio) {
        int students = kattio.getInt();
        int[] arr = new int[students];
        for (int i = 0; i < students; i++) {
            arr[i] = kattio.getInt();
        }
        int sum = Arrays.stream(arr).sum();
        double average = sum / arr.length;
        double count = 0;
        for (int i : arr) {
            if (i > average) {
                count++;
            }
        }
        double d = count / arr.length;
        String s = String.format("%.3f", d * 100);
        kattio.println(s + "%");
        //kattio.println(String.format("%.5f", count / arr.length));
    }
}