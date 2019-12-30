import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Islands {

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int r = io.getInt();
        int c = io.getInt();
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = io.getLine();
            map[i] = line.toCharArray();
        }
        int count = 0;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] == 'L') {
                    count++;
                    DFS(map, visited, count, new Pair(i, j), io);
                }
            }
        }
        io.println(count);
        io.close();
    }

    static void DFS(char[][] map, boolean[][] visited, int count, Pair start, Kattio io) {
        Stack<Pair> stack = new Stack<>();
        visited[start.x][start.y] = true;
        stack.push(start);
        while (!stack.isEmpty()) {
            Pair curr = (Pair) stack.pop();
            List<Pair> neighbours = new ArrayList<Pair>();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == j || i == -j) continue; // diagonals wont work!
                    if (inBounds(curr.x + i, curr.y + j, map.length, map[0].length)) {
                        neighbours.add(new Pair(curr.x + i, curr.y + j));
                    }
                }
            }
            for (Pair neighbour : neighbours) {
                if (!visited[neighbour.x][neighbour.y]) {
                    if (map[neighbour.x][neighbour.y] == 'L' || map[neighbour.x][neighbour.y] == 'C') {
                        visited[neighbour.x][neighbour.y] = true;
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    static boolean inBounds(int i, int j, int row, int col) {
        return 0 <= i && i < row && 0 <= j && j < col;
    }

    static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
}