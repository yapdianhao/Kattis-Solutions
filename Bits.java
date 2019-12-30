class Bits {
    
    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int c = io.getInt();
        for (int i = 0; i < c; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        String s = io.getWord();
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            int curr = Integer.parseInt(s.substring(0, i));
            if (count(curr) > max) max = count(curr);
        }
        io.println(max);
    }

    static int count(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();
        int res = 0;
        for (char c : arr) {
            if (c == '1') {
                res++;
            }
        }
        return res;
    }
}