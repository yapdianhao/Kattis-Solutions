class Mega {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
        }
        for (int i = 0; i < n; i++) {
            io.println(arr[i]);
        }
        io.close();
    }
}