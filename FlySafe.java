import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class FlySafe {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        while (cases-- > 0) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int nodes = io.getInt();
        int edges = io.getInt();
        boolean[] visited = new boolean[nodes];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int start = io.getInt() - 1;
            int end = io.getInt() - 1;
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        int ct = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited[curr]) continue;
            visited[curr] = true;
            ct++;
            for (int i : adj.get(curr)) {
                if (!visited[i]) q.add(i);
            }
        }
        io.println(ct - 1);
    }
}