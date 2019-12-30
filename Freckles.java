import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Freckles {

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
        Node[] nodearr = new Node[nodes];
        for (int i = 0; i < nodes; i++) {
            nodearr[i] = new Node(io.getDouble(), io.getDouble());
        }
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                double w = getDist(nodearr[i], nodearr[j]);
                adj.get(i).add(new Edge(i, j, w));
                adj.get(j).add(new Edge(j, i, w));
            }
        }
        boolean[] visited = new boolean[nodes];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[0] = true;
        for (Edge edge : adj.get(0)) {
            pq.add(edge);
        }
        double res = 0;
        /*int t = 0;
        while (!pq.isEmpty() && t < nodes - 1) {
            Edge curr = pq.poll();
            if (visited[curr.src] && visited[curr.dest]) continue;
            visited[curr.src] = visited[curr.dest] = true;
            res += curr.w;
            t++;
            if (visited[curr.src]) {
                for (Edge n : adj.get(curr.src)) {
                    pq.add(n);
                } 
            }
            if (visited[curr.dest]) {
                for (Edge n : adj.get(curr.dest)) {
                    pq.add(n);
                }
            }
        }*/
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.dest]) continue;
            io.println(curr);
            res += curr.w;
            visited[curr.dest] = true;
            for (Edge neighbour : adj.get(curr.dest)) {
                if (!visited[neighbour.dest]) pq.add(neighbour);
            }
        }
        io.printf("%.2f", res);
        io.println();
    }

    static double getDist(Node f, Node s) {
        double h = f.x - s.x;
        double v = f.y - s.y;
        return Math.sqrt(Math.pow(h, 2) + Math.pow(v, 2));
    }

    static class Node {

        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        double w;

        public Edge(int src, int dest, double w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }

        public int compareTo(Edge ot) {
            return this.w < ot.w ? -1 : 1;
        }

        public String toString() {
            return this.w + "";
        }
    }
}