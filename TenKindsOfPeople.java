import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TenKindsOfPeople {

    // Just do it!
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int row = io.getInt();
        int col = io.getInt();
        int[][] map = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int[][] mapped = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = io.getWord();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                map[i][j] = Character.getNumericValue(c);
            }
        }
        Pair start = new Pair(0, 0);
        int id = 1;
        DFS(map, mapped, visited, start, id++);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    DFS(map, mapped, visited, new Pair(i, j), id++);
                }
            }
        }      
        int query = io.getInt();
        for (int i = 0; i < query; i++) {
            solve(io, mapped, map);
        }
        io.close();
    }

    //flood fill
    static void DFS(int[][] map, int[][] mapped, boolean[][] visited, Pair start, int id) {
        Stack<Pair> stack = new Stack<Pair>();
        visited[start.x][start.y] = true;
        mapped[start.x][start.y] = id;
        stack.push(start);
        while (!stack.isEmpty()) {
            Pair curr = (Pair) stack.pop();
            curr.addNeighBours(map, visited);
            for (Pair neighbour : curr.neighbours) {
                if (!visited[neighbour.x][neighbour.y]) {
                    visited[neighbour.x][neighbour.y] = true;
                    mapped[neighbour.x][neighbour.y] = id;
                    stack.push(neighbour);
                }
            }
        }
    }

    static void solve(Kattio io, int[][] mapped, int[][] map) {
        int r1 = io.getInt();
        int c1 = io.getInt();
        int r2 = io.getInt();
        int c2 = io.getInt();
        if (mapped[r1 - 1][c1 - 1] == mapped[r2 - 1][c2 - 1]) {
            if (map[r1 - 1][c1 - 1] == 1) {
                io.println("decimal");
            } else if (map[r2 - 1][c2 - 1] == 0) {
                io.println("binary");
            }
        } else {
            io.println("neither");
        }
    }

    // Pair class.
    static class Pair {
        int x;
        int y;
        List<Pair> neighbours;

        // constructor
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.neighbours = new ArrayList<Pair>();
        }

        public void addNeighBours(int[][] map, boolean[][] visited) {
            try {
                int x = this.x + 1;
                int y = this.y;
                Pair down = new Pair(x, y);
                if (map[this.x][this.y] == map[x][y]) {
                    neighbours.add(down);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // do nothing if array out of index
            }
            try {
                int x = this.x - 1;
                int y = this.y;
                Pair up = new Pair(x, y);
                if (map[this.x][this.y] == map[x][y]) {
                    neighbours.add(up);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // do nothing
            }
            try {
                int x = this.x;
                int y = this.y + 1;
                Pair right = new Pair(x, y);
                if (map[this.x][this.y] == map[x][y]) {
                    neighbours.add(right);
                }
            } catch (ArrayIndexOutOfBoundsException e){
                // zzzz
            }
            try {
                int x = this.x;
                int y = this.y - 1;
                Pair left = new Pair(x, y);
                if (map[this.x][this.y] == map[x][y]) {
                    neighbours.add(left);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // wtf
            }
        } // findNeighbour function ends here
    }
}