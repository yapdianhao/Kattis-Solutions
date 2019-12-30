class OddGnome {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int groups = io.getInt();
        for (int i = 0; i < groups; i++) {
            io.println(solve(io) + 1);
        }
        io.close();
    }

    public static int solve(Kattio io) {
        int gnomes = io.getInt();
        int[] arr = new int[gnomes];
        for (int i = 0; i < gnomes; i++) {
            arr[i] = io.getInt();
        }
        for (int i = 1; i < gnomes - 1; i++) {
            if (arr[i] - arr[i - 1] != 1) {
                return i;
            } 
        }
        return -1;
    }
}