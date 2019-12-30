class Relocation {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int n = io.getInt();
        int q = io.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
        }
        for (int i = 0; i < q; i++) {
            int l = io.getInt();
            if (l == 1) {
                int p = io.getInt() - 1;
                int t = io.getInt();
                arr[p] = t;
            } else if (l == 2) {
                int f = io.getInt() - 1;
                int g = io.getInt() - 1;
                io.println(Math.abs(arr[g] - arr[f]));
            }
        }
        io.close();
    }
}