import java.util.Arrays;

class DASort {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int tests = io.getInt();
        for (int i = 0; i < tests; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int shit = io.getInt();
        int nums = io.getInt();
        int[] arr = new int[nums];
        int[] temp = new int[nums];
        for (int i = 0; i < nums; i++) {
            temp[i] = arr[i] = io.getInt();
        }
        Arrays.sort(temp);
        int ans = 0;
        for (int i = 0; i < nums; i++) {
            if (arr[i] == temp[ans]) ans++;
        }
        io.println(shit + " " + (nums - ans));
    }
}