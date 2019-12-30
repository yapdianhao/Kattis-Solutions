import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Coast {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int r = io.getInt();
        int c = io.getInt();
        char[][] map = new char[r + 2][c + 2];
        boolean[][] visited = new boolean[r][c];
        Arrays.fill(map[0], '0');
        Arrays.fill(map[r + 1], '0');
        for (int i = 1; i <= r; i++) {
            char[] arr = io.getLine().toCharArray();
            map[i][0] = '0';
            for (int j = 1; j <= c; j++) {
                map[i][j] = arr[j - 1];
            }
            map[i][c + 1] = '0';
        }
        /*for (int i = 0; i < r + 2; i++) {
            io.println(Arrays.toString(map[i]));
        }*/
        int count = 0;
        Pair start = new Pair(0, 0);
        BFS(start, map);
        for (int i = 1; i < r + 2; i++) {
            for (int j = 1; j < c + 2; j++) {
                if (map[i][j] == '1') {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if (x == y || x == -y) continue;
                            if (map[i + x][j + y] == ' ') count++;
                        }
                    }
                }
            }
        }
        /*for (int i = 0; i < r + 2; i++) {
            io.println(Arrays.toString(map[i]));
        }*/
        io.println(count);
        io.close();
    }

    static void BFS(Pair start, char[][] map) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (map[curr.x][curr.y] != '0') continue;
            map[curr.x][curr.y] = ' ';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == j || j == -i) continue;
                    if (inBounds(curr.x + i, curr.y + j, map.length, map[0].length)) {
                        if (map[curr.x + i][curr.y + j] != '0') continue;
                        else q.add(new Pair(curr.x + i, curr.y + j));
                    }
                }
            }
        }
    }

    static boolean inBounds(int i, int j, int r, int c) {
        return 0 <= i && i < r && 0 <= j && j < c;
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