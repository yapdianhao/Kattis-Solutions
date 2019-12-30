class Statistics {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int count = 1;
        while(io.hasMoreTokens()) {
            int n = io.getInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = io.getInt();
            }
            int min = (int)Math.pow(10, 9);
            int max = -min;
            for (int i : arr) {
                if (i < min) {
                    min = i;
                }
                if (i > max) {
                    max = i;
                }
            }
            io.println("Case " + count + ": " + min + " " + max + " " + (max - min));
            count++;
            io.flush();
        }
    }
}