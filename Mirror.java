import java.util.Arrays;

class Mirror {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve(i + 1);
        }
        io.close();
    }

    static void solve(int x) {
        io.println("Test " + x);
        int r = io.getInt();
        int c = io.getInt();
        char[][] pic = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] line = io.getLine().toCharArray();
            pic[i] = line;
        }
        char[][] res = new char[r][c];
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                res[r - 1 - i][c - 1 - j] = pic[i][j];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                io.print(res[i][j]);
            }
            io.print("\n");
        }
    }
}