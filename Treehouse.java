import java.util.PriorityQueue;

class Treehouse {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int nodes = io.getInt();
        int done = io.getInt();
        int connected = io.getInt();
        int[] parent = new int[nodes];
        int[] size = new int[nodes];
        Node[] nodearr = new Node[nodes];
        //boolean[visited] = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            nodearr[i] = new Node(io.getDouble(), io.getDouble());
            parent[i] = i;
            size[i] = 1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                double dist = getDist(nodearr[i], nodearr[j]);
                pq.add(new Edge(i, j, dist));
            }
        }
        for (int i = 0; i < done; i++) {
            //boolean[i] = true;
            if (i == 0) continue;
            else {
                if (!find(0, i, parent)) {
                    union(0, i, parent, size);
                    //boolean[i] = true;
                }
            }
        }
        for (int i = 0; i < connected; i++) {
            int src = io.getInt() - 1;
            int dest = io.getInt() - 1;
            if (!find(src, dest, parent)) {
                union(src, dest, parent, size);
            }
        }
        double ans = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (!find(curr.src, curr.dest, parent)) {
                union(curr.src, curr.dest, parent, size);
                ans += curr.w;
            }
        }
        io.printf("%.6f", ans);
        io.println();
        io.close();
    }

    static double getDist(Node f, Node s) {
        double h = s.x - f.x;
        double v = s.y - f.y;
        return Math.sqrt(Math.pow(h, 2) + Math.pow(v, 2));
    }

    static boolean find(int p, int q, int[] parent) {
        return findRoot(p, parent) == findRoot(q, parent);
    }

    static int findRoot(int p, int[] parent) {
        int root = p;
        while (parent[root] != root) root = parent[root];
        while (parent[p] != p) {
            int temp = parent[p];
            parent[p] = root;
            p = temp;
        }
        return root;
    }

    static void union(int p, int q, int[] parent, int[] size) {
        while (parent[p] != p) p = parent[p];
        while (parent[q] != q) q = parent[q];
        if (size[p] > size[q]) {
            parent[q] = p;
            size[p] += size[q];
        } else {
            parent[p] = q;
            size[q] += size[p];
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
            return this.w > ot.w ? 1 : -1;
        }
    }

    static class Node {
        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
}