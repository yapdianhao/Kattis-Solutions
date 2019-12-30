class Speed {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        while (cases != -1) {
            solve(cases);
            cases = io.getInt();
        }
        io.close();
    }

    static void solve(int x) {
        int total = 0;
        int hr = 0;
        for (int i = 0; i < x; i++) {
            int curr = io.getInt();
            int temp = io.getInt();
            total += curr * (temp - hr);
            hr = temp;
        }
        io.println(total + " miles");
    }
}