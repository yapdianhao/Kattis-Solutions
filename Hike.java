class Hike {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int days = io.getInt();
        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = io.getInt();
        }
        int maxt = 50;
        int idx = 0;
        for (int i = 0; i < days - 2; i++) {
            int max = Math.max(arr[i], arr[i + 2]);
            if (max < maxt) {
                maxt = max;
                idx = i + 1;
            }
        }
        io.println(idx + " " + maxt);
        io.close();
    }
}