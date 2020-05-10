import java.util.Arrays;

class Closest {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = 1;
        while(io.hasMoreTokens()) {
            solve(cases);
            cases++;
            io.flush();
        }
    }

    static void solve(int cases) {
        io.println("Case " + cases + ":");
        int n = io.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
        }
        Arrays.sort(arr);
        int q = io.getInt();
        while (q-- > 0) {
            int idx1 = -1;
            int idx2 = -1;
            int target = io.getInt();
            int diff = (int) Math.pow(10, 9);
            int l = 0;
            int r = arr.length - 1;
            while (l < r) {
                if (Math.abs(arr[l] + arr[r] - target) < diff) {
                    idx1 = l;
                    idx2 = r;
                    diff = Math.abs(arr[l] + arr[r] - target);
                }
                if (arr[l] + arr[r] < target) {
                    l++;
                } else r--;
            }
            io.println("Closest sum to " + target + " is " + (arr[idx1] + arr[idx2]) + ".");
        }
    }
}