import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class IslandHop {

    static Kattio io = new Kattio(System.in);

    public static void main(String args[]) {
        int cases = io.getInt();
        while (cases-- > 0) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int nodes = io.getInt();
        Node[] nodearr = new Node[nodes];
        int[] parent = new int[nodes];
        int[] size = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            nodearr[i] = new Node(io.getDouble(), io.getDouble(), i);
            parent[i] = i;
            size[i] = 1;
        }
        List<Edge> el = new ArrayList<>();
        for (int i = 0; i < nodes - 1; i++) {
            for (int j = i + 1; j < nodes; j++) {
                el.add(new Edge(nodearr[i].key, nodearr[j].key, getDist(nodearr[i], nodearr[j])));
            }
        }
        Collections.sort(el);
        //io.println(el);
        double dist = 0;
        for (Edge e : el) {
            if (!find(e.src, e.dest, parent)) {
                dist += e.w;
                union(e.src, e.dest, parent, size);
            }
        }
        io.println(dist);
    }

    static boolean find(int src, int dest, int[] parent) {
        return findRoot(src, parent) == findRoot(dest, parent);
    }

    static int findRoot(int root, int[] parent) {
        while (parent[root] != root) {
            parent[root] = parent[parent[root]];
            root = parent[root];
        }
        return root;
    }

    static void union(int src, int dest, int[] parent, int[] size) {
        src = findRoot(src, parent);
        dest = findRoot(dest, parent);
        if (size[src] < size[dest]) {
            parent[src] = parent[dest];
            size[dest] += size[src];
        } else {
            parent[dest] = parent[src];
            size[src] += size[dest];
        }
    }
    static double getDist(Node f, Node s) {
        double h = Math.pow(f.x - s.x, 2);
        double v = Math.pow(f.y - s.y, 2);
        return Math.sqrt(h + v);
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
            return this.w >= ot.w ? 1 : -1;
        }

        public String toString() {
            return "(" + this.src + ", " + this.dest + ", " + this.w + ")";
        }
    }

    static class Node {

        int key;
        double x;
        double y;

        public Node(double x, double y, int key) {
            this.key = key;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
}