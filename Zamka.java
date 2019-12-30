class Zamka {

    public static void main(String []args) {
        Kattio io = new Kattio(System.in);
        int start = io.getInt();
        int stop = io.getInt();
        int target = io.getInt();
        for (int i = start; i <= stop; i++) {
            if (sum(i) == target) {
                io.println(i);
                break;
            }
        }
        for (int i = stop; i >= start; i--) {
            if (sum(i) == target) {
                io.println(i);
                break;
            }
        }
        io.close();
    }

    static int sum(int n) {
        int res = 0;
        char[] arr = ("" + n).toCharArray();
        for (char c : arr) {
            res += Character.getNumericValue(c);
        }
        return res;
    }
}