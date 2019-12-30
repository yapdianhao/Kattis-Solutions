import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KindsOfPeople {
    private static Kattio io = new Kattio(System.in);
    private static int row;
    private static int col;
    private static int count = 2;
    private static int[][] map;
    private static int[] forRow = new int[] { -1, 0, 0, 1 };
    private static int[] forCol = new int[] { 0, -1, 1, 0 };

    private static void DFS(int x, int y, int usr) {
        /*
        if (map[x][y] > 1) {
            return;
        } else {
            map[x][y] = count;
            for (int i = 0; i < 4; i++) {
                int r = x + forRow[i];
                int c = y + forCol[i];
                if (r >= 0 && c >= 0 && r < row && c < col) {
                    if (map[r][c] == usr) {
                        DFS(r, c, usr);
                    }
                }
            }
        }*/
        Stack<Integer> xstack = new Stack<>();
        Stack<Integer> ystack = new Stack<>();
        xstack.push(x);
        ystack.push(y);
        while (!xstack.isEmpty() && !ystack.isEmpty()) {
            int currx = xstack.pop();
            int curry = ystack.pop();
            map[currx][curry] = count;
            for (int i = 0; i < 4; i++) {
                int r = currx + forRow[i];
                int c = curry + forCol[i];
                if (r >= 0 && c >= 0 && r < row && c < col) {
                    if (map[r][c] == usr) {
                        xstack.push(r);
                        ystack.push(c);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        row = io.getInt();
        col = io.getInt();
        int[][] cp = new int[row][col];
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            char[] temp = io.getWord().toCharArray();
            for (int j = 0; j < col; j++) {
                if (temp[j] == '1') {
                    map[i][j] = 1;
                    cp[i][j] = 1;
                } else {
                    map[i][j] = 0;
                    cp[i][j] = 0;
                }
            }
            /*for (int j = 0; j < col; j++) {
                char c = temp.charAt(j);
                map[i][j] = Character.getNumericValue(c);
                cp[i][j] = map[i][j];
            }*/
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] < 2) {
                    DFS(i, j, map[i][j]);
                    count++;
                }
            }
        }
        
        /*for (int i = 0; i < row; i++) {
        //     io.print("row: ");
             for (int j = 0; j < col; j++) {
                 io.print(map[i][j]);
             }
            io.println();
        }*/

        int n = io.getInt();
        for (int i = 0; i < n; i++) {
            int srcX = io.getInt();
            int srcY = io.getInt();
            String user = cp[srcX - 1][srcY - 1] == 0 ? "binary" : "decimal";

            if (map[io.getInt() - 1][io.getInt() - 1] != map[srcX - 1][srcY - 1]) {
                io.println("neither");
            } else {
                io.println(user);
            }
        }

        io.close();
    }
}