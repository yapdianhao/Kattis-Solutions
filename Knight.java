import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Knight {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] xmove = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] ymove = {1, -1, 1, -1, 2, -2, 2, -2};
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] row = io.getWord().toCharArray();
            grid[i] = row;
        }
        int knightPosx = -1;
        int knightPosy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'K') {
                    knightPosx = i;
                    knightPosy = j;
                }
            }
        }
        boolean[][] visited = new boolean[n][n];
        int[][] ans = new int[n][n];
        Queue<Integer> xqueue = new LinkedList<>();
        Queue<Integer> yqueue = new LinkedList<>();
        xqueue.add(knightPosx);
        yqueue.add(knightPosy);
        int count = 0;
        visited[knightPosx][knightPosy] = true;
        while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
            int currx = xqueue.poll();
            int curry = yqueue.poll();
            if (currx == 0 && curry == 0) break;
            for (int i = 0; i < xmove.length; i++) {
                if (-1 < currx + xmove[i] && currx + xmove[i] < n && -1 < ymove[i] + curry && ymove[i] + curry < n) {
                    if (!visited[currx + xmove[i]][curry + ymove[i]] && grid[currx + xmove[i]][curry + ymove[i]] != '#') {
                        ans[currx + xmove[i]][curry + ymove[i]] = ans[currx][curry] + 1;
                        visited[currx + xmove[i]][curry + ymove[i]] = true;
                        xqueue.add(currx + xmove[i]);
                        yqueue.add(curry + ymove[i]);
                    } else if (!visited[currx + xmove[i]][curry + ymove[i]] && grid[currx + xmove[i]][curry + ymove[i]] != '#') {
                        visited[currx + xmove[i]][curry + ymove[i]] = true;
                    }
                }
            }
        }
        if (visited[0][0]) io.println(ans[0][0]);
        else io.println(-1);
        io.close();
    }
}