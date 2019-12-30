class CookingWater {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int t = io.getInt();
        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            arr[i][0] = io.getInt();
            arr[i][1] = io.getInt();
        }
        for (int i = 0; i < t; i++) {
            if (arr[i][0] == arr[i][1]) {
                io.println("gunilla has a point");
                io.close();
                return;
            }
        }
        io.println("edward is right");
        io.close();
    }
}