import java.util.Arrays;
import java.util.Stack;

class Star {
    
    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int f = 1;
        while (io.hasMoreTokens()) {
            int count = 0;
            int r = io.getInt();
            int c = io.getInt();
            char[][] sky = new char[r][c];
            for (int i = 0; i < r; i++) {
                sky[i] = io.getLine().toCharArray();
            }
            boolean[][] visited = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (sky[i][j] == '-' && !visited[i][j]) {
                        BFS(sky, visited, i, j);
                        count++;
                    }
                }
            }
            io.println("Case " + f + ": " + count);
            f++;
            io.flush();
        }
    }

    static void BFS(char[][] sky, boolean[][] visited, int x, int y) {
        Pair start = new Pair(x, y);
        Stack<Pair> s = new Stack<>();
        s.add(start);
        visited[x][y] = true;
        while (!s.isEmpty()) {
            Pair curr = s.pop();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == j || i == -j) continue;
                    if (inBounds(curr.x + i, curr.y + j, sky.length, sky[0].length)) {
                        if (!visited[curr.x + i][curr.y + j] && sky[curr.x + i][curr.y + j] == '-') {
                            visited[curr.x + i][curr.y + j] = true;
                            s.add(new Pair(curr.x + i, curr.y + j));
                        }
                    }
                }
            }
        }
    }

    static boolean inBounds(int x, int y, int r, int c) {
        return -1 < x && x < r && -1 < y && y < c;
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