import java.util.*;

class Fire {

    public static void main(String[] args) {
        int n, m;
        Kattio io = new Kattio(System.in);
        n = io.getInt();
        m = io.getInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = io.getWord().toCharArray();
        }
        int joeX = -1;
        int joeY = -1;
        List<List<Integer>> fires = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'J') {
                    joeX = i;
                    joeY = j;
                } else if (grid[i][j] == 'F') {
                    List<Integer> fire = new ArrayList<>();
                    fire.add(i);
                    fire.add(j);
                    fires.add(fire);
                }
            }
        }
        int joeEscape = BFS(grid, new Point(joeX, joeY, 0));
        int fireCatch = Integer.MAX_VALUE;
        for (List<Integer> fire : fires) {
            Point firePoint = new Point(fire.get(0), fire.get(1), 0);
            fireCatch = Math.min(fireCatch, BFS(grid, firePoint));
        }
        io.println(joeEscape);
        io.println(fireCatch);
        if (fireCatch < joeEscape) {
            io.println("IMPOSSIBLE");
        } else {
            io.println(joeEscape == Integer.MAX_VALUE ? "IMPOSSIBLE" : joeEscape);
        }
        io.close();
    }

    static int BFS(char[][] grid, Point start) {
        Queue<Point> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        queue.add(start);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            visited[curr.x][curr.y] = true;
            for (int[] direction: directions) {
                int newX = curr.x + direction[0];
                int newY = curr.y + direction[1];
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                    return curr.dist + 1;
                } else if (visited[newX][newY]) {
                    continue;
                } else if (grid[newX][newY] == '.') {
                    queue.add(new Point(newX, newY, curr.dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

class Point {
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}