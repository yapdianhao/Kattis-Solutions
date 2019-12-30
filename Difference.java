class Difference {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        String word1 = io.getWord();
        String word2 = io.getWord();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        String s = "";
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                s += "*";
            } else s += ".";
        }
        io.println(word1);
        io.println(word2);
        io.println(s);
        io.println();
    }
}