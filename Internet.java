import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Internet {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int nodes = io.getInt();
        int edges = io.getInt();
        boolean[] visited = new boolean[nodes];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int src = io.getInt() - 1;
            int dest = io.getInt() - 1;
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        Stack<Integer> s = new Stack<>();
        //visited[0] = true;
        s.add(0);
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (visited[curr]) continue;
            visited[curr] = true;
            for (int i : adj.get(curr)) {
                if (!visited[i]) s.add(i);
            }
        }
        boolean flag = true;
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                io.println(i + 1);
                flag = false;
            }
        }
        if (flag) io.println("Connected");
        io.close();
    }
}