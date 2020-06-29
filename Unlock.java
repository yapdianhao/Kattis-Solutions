import java.util.*;

class Unlock {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int[][] grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = io.getInt();
            }
        }
        int posX = -1;
        int posY = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 1) {
                    posX = i;
                    posY = j;
                }
            }
        }
        double total = 0;
        for (int i = 1; i < 9; i++) {
            int[] updated = upDate(grid, i, posX, posY);
            //System.out.println(Arrays.toString(updated));
            total += Math.sqrt(Math.pow(updated[0] - posX, 2) + Math.pow(updated[1] - posY, 2));
            //System.out.println(total);
            posX = updated[0];
            posY = updated[1];
        }
        io.println(total);
        io.close();
    }

    static int[] upDate(int[][] grid, int x, int posX, int posY) {
        int[] updated = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == x + 1) {
                    updated[0] = i;
                    updated[1] = j;
                }
            }
        }
        return updated;
    }

    static boolean inLine(int[][] grid, int x, int posX, int posY) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            if (posX  + dirX[i] < 0 || posX + dirX[i] >= grid.length || posY + dirY[i] < 0 || posY+ dirY[i] >= grid[0].length) continue;
            if (grid[posX + dirX[i]][posY + dirY[i]] == x + 1) return true;
        }
        return false;
    }
}