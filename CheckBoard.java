import java.util.*;

class CheckBoard {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int s = io.getInt();
        char[][] grid = new char[s][s];
        for (int i = 0; i < s; i++) {
            grid[i] = io.getWord().toCharArray();
        }
        //io.println(countRow(grid));
        //io.println(countCol(grid));
        //io.println(rowEqual(grid));
        //io.println(colEqual(grid));
        if (countRow(grid) && countCol(grid) && rowEqual(grid) && colEqual(grid)) io.println(1);
        else io.println(0);
        io.close();
    }

    static boolean countRow(char[][] grid) {
        boolean res = true;
        for (int i = 0; i < grid.length; i++) {
            int count = 1;
            for (int j = 0; j < grid.length - 1; j++) {
                //System.out.println(i + " " + j);
                if (grid[i][j + 1] == grid[i][j]) count++;
                else count = 1;
                if (count >= 3) return false;
            }
        }
        return res;
    }

    static boolean countCol(char[][] grid) {
        boolean res = true;
        for (int i = 0; i < grid.length; i++) {
            int count = 1;
            for (int j = 0; j < grid.length - 1; j++) {
                //System.out.println(j + " " + i);
                if (grid[j + 1][i] == grid[j][i]) count++;
                else count = 1;
                if (count >= 3) return false;
            }
        }
        return res;
    }

    static boolean rowEqual(char[][] grid) {
        boolean res = true;
        for (int i = 0; i < grid.length; i++) {
            int b = 0;
            int w = 0;
            for (char c : grid[i]) {
                if (c == 'B') b++;
                if (c == 'W') w++;
            }
            if (b != w) {
                res = false;
                break;
            }
        }
        return res;
    }

    static boolean colEqual(char[][] grid) {
        boolean res = true;
        for (int i = 0; i < grid.length; i++) {
            int b = 0;
            int w = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 'B') b++;
                if (grid[j][i] == 'W') w++;
            }
            if (b != w) {
                res = false;
                break;
            }
        }
        return res;
    }
}