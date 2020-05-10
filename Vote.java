class Vote {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int n = io.getInt();
        int[] arr = new int[n];
        int total = 0;
        for (int j = 0; j < n; j++) {
            arr[j] = io.getInt();
            total += arr[j];
        }
        if (gotSame(arr)) {
            io.println("no winner");
            return;
        }
        int max = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        idx++;
        //if (total % 2 == 0) io.println(max > total / 2 ? ("majority winner " + idx) : ("minority winner " + idx));
        //else io.println(max > total / 2 + 1 ? "majority winner " + idx : "minority winner " + idx);
        io.println(max > total / 2 ? ("majority winner " + idx) : ("minority winner " + idx));
    }

    static boolean allSame(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) return false;
        }
        return true;
    }

    static boolean gotSame(int[] arr) {
        int t = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > t) t = arr[i];
        }
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) c++;
        }
        return c != 1;
    }
}