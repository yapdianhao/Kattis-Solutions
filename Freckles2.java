import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;

class Freckles2 {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int n = io.getInt();
        Node[] nodearr = new Node[n];
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            nodearr[i] = new Node(i, io.getDouble(), io.getDouble());
            size[i] = 1;
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //List<Edge> el = new LinkedList<Edge>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double w = getDist(nodearr[i], nodearr[j]);
                pq.add(new Edge(i, j, w));
            }
        }
        //io.println(pq);
        //Collections.sort(el);
        double r = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            //io.println(e);
            if (!find(e.src, e.dest, parent)) {
                //io.println(e);
                r += e.w;
                union(parent, size, e.src, e.dest);
            }
        }
        io.printf("%.02f\n", r);
        //io.println(Arrays.toString(nodearr));
        //io.println(pq);
    }

    static boolean find(int src, int dest, int[] parent) {
        //return parent[src] == parent[dest];
        return findRoot(src, parent) == findRoot(dest, parent);
    }

    static void union(int[] parent, int[] size, int src, int dest) {
        //(findRoot(src, parent) == findRoot(dest, parent)) return;
        src = findRoot(src, parent);
        dest = findRoot(dest, parent);
        //if (parent[src] == parent[dest]) return;
        //while (parent[src] != src) src = parent[src];
        //while (parent[dest] != dest) dest = parent[dest];
        if (src == dest) return;
        if (size[src] > size[dest]) {
            parent[dest] = src;
            size[src] += size[dest];
        } else {
            parent[src] = dest;
            size[dest] += size[src];
        }
        /*int temp = parent[dest];
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == temp) parent[i] = parent[src];
        }*/
    }

    static int findRoot(int src, int[] parent) {
        /*while (parent[src] != src) {
            parent[src] = parent[parent[src]];
            src = parent[src];
        }
        return src;*/
        int root = src;
        while (parent[root] != root) root = parent[root];
        while (parent[src] != src) {
            int temp = parent[src];
            parent[src] = root;
            src = temp;
        }
        return root;
    }

    static double getDist(Node f, Node s) {
        double v = f.y - s.y;
        double h = f.x - s.x;
        return Math.sqrt(Math.pow(v, 2) + Math.pow(h, 2));
    }

    static class Node {
        int key;
        double x;
        double y;

        public Node(int key, double x, double y) {
            this.key = key;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.key + ", " + this.x + ", " + this.y + ")";
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