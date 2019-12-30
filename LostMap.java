import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class LostMap {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int v = io.getInt();
        boolean[] visited = new boolean[v];
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Edge>());
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        PriorityQueue<Edge> path = new PriorityQueue<>();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                //if (i == j) continue;
                int src = i;
                int dest = j;
                long w = io.getLong();
                adj.get(src).add(new Edge(src, dest, w));
                //adj.get(dest).add(new Edge(dest, src, w));
            }
        }
        visited[0] = true;
        for (Edge n : adj.get(0)) {
            pq.add(n);
        }
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.dest]) continue;
            path.add(curr);
            visited[curr.dest] = true;
            for (Edge neigh : adj.get(curr.dest)) {
                if (!visited[neigh.dest]) pq.add(neigh);
            }
        }
        while (!path.isEmpty()) {
            Edge curr = path.poll();
            io.println((curr.src + 1) + " " + (curr.dest + 1));
        }
        io.close();
    }

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        long w;

        public Edge(int src, int dest, long w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }

        public int compareTo(Edge other) {
            return  (int) (this.w - other.w);
        }

        public String toString() {
            return "(" + src + ", " + dest + ", " + w + ")";
        }
    }
}