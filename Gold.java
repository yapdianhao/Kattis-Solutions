import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Gold {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int c = io.getInt();
        int r = io.getInt();
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] line = io.getLine().toCharArray();
            map[i] = line;
        }
        boolean[][] visited = new boolean[r][c];
        int gold = 0;
        Pair start = new Pair(0, 0);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'P') {
                    start = new Pair(i, j);
                    break;
                }
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (map[curr.x][curr.y] == 'G') {
                gold++;
            }
            if (map[curr.x + 1][curr.y] == 'T' || map[curr.x - 1][curr.y] == 'T' ||
                map[curr.x][curr.y + 1] == 'T' || map[curr.x][curr.y - 1] == 'T') {
                continue;
            }
            if ((map[curr.x + 1][curr.y] == 'G' || map[curr.x + 1][curr.y] == '.') &&
                !visited[curr.x + 1][curr.y]) {
                visited[curr.x + 1][curr.y] = true;
                q.add(new Pair(curr.x + 1, curr.y));
            }
            if ((map[curr.x - 1][curr.y] == 'G' || map[curr.x - 1][curr.y] == '.') &&
                !visited[curr.x - 1][curr.y]) {
                visited[curr.x - 1][curr.y] = true;
                q.add(new Pair(curr.x - 1, curr.y));
            }
            if ((map[curr.x][curr.y + 1] == 'G' || map[curr.x][curr.y + 1] == '.') &&
                !visited[curr.x][curr.y + 1]) {
                visited[curr.x][curr.y + 1] = true;
                q.add(new Pair(curr.x, curr.y + 1));
            }
            if ((map[curr.x][curr.y - 1] == 'G' || map[curr.x][curr.y - 1] == '.') &&
                !visited[curr.x][curr.y - 1]) {
                visited[curr.x][curr.y - 1] = true;
                q.add(new Pair(curr.x, curr.y - 1));
            }
            /*for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == j || i == -j) continue;
                    //if (inBounds(curr.x + i, curr.y + j, c, r)) {
                        if (map[curr.x + i][curr.y + j] == 'T') continue;
                        if (!visited[curr.x + i][curr.y + j] && (map[curr.x + i][curr.y + j] == '.'
                            || map[curr.x + i][curr.y + j] == 'G')) {
                            q.add(new Pair(curr.x + i, curr.y + j));
                            visited[curr.x + i][curr.y + j] = true;
                       // }
                    }
                }
            }*/
        }
        io.println(gold);
        io.close();
    }

    static boolean inBounds(int x, int y, int r, int c) {
        return 0 <= x && x < c && 0 <= y && y < r;
    }

    static class Pair {

         int x;
         int y;

         public Pair(int x, int y) {
            this.x = x;
            this.y = y;
         }
    }
}