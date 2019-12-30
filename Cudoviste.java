import java.util.Arrays;

class Cudoviste {

    static int[] arrx = {1, 0, 1, 0};
    static int[] arry = {1, 1, 0, 0};
    static int zero = 0;
    static int one = 0;
    static int two = 0;
    static int three = 0;
    static int four = 0;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int row = io.getInt();
        int col = io.getInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            grid[i] = io.getWord().toCharArray();
        }
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int ans = solve(grid, i, j);
                //io.println(ans + " " + i + " " + j);
                if (ans == 0) zero++;
                if (ans == 1) one++;
                if (ans == 2) two++;
                if (ans == 3) three++;
                if (ans == 4) four++;
            }
        }
        io.println(zero);
        io.println(one);
        io.println(two);
        io.println(three);
        io.println(four);
        io.close();
    }

    static int solve(char[][] grid, int i, int j) {
        int res = 0;
        for (int x = 0; x < 4; x++) {
                if (grid[i + arrx[x]][arry[x] + j] == '#') return -1;
                else if (grid[i + arrx[x]][arry[x] + j] == 'X') res++;
        }
        return res;
    }
}