import java.util.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Dominoes2 {
    
    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int nodes = io.getInt();
        int edges = io.getInt();
        int knocked = io.getInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int src = io.getInt() - 1;
            int dest = io.getInt() - 1;
            adj.get(src).add(dest);
        }
        boolean[] visited = new boolean[nodes];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < knocked; i++) {
            int start = io.getInt() - 1;
            s.add(start);
            while (!s.isEmpty()) {
                int curr = s.pop();
                if (visited[curr]) continue;
                visited[curr] = true;
                for (int j : adj.get(curr)) {
                    if (!visited[j]) s.add(j);
                }
            }
        }
        int c = 0;
        for (boolean b : visited) {
            if (b) c++;
        }
        //io.println(Arrays.toString(visited));
        io.println(c);
    }
}