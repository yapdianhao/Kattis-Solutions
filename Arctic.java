import java.util.Arrays;
import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Arctic {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        while (cases-- > 0) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int satellites = io.getInt();
        int outposts = io.getInt();
        Node[] nodes = new Node[outposts];
        int[] parent = new int[outposts];
        int[] size = new int[outposts];
        for (int i = 0; i < outposts; i++) {
            nodes[i] = new Node(i, io.getInt(), io.getInt());
            parent[i] = i;
            size[i] = 1;
        }
        List<Edge> el = new ArrayList<>();
        //PriorityQueue<Edge> pq = new PriorityQueue<>();
        Stack<Edge> stack = new Stack<Edge>();
        LinkedList<Edge> edges = new LinkedList<>();
        for (int i = 0; i < outposts; i++) {
            for (int j = i + 1; j < outposts; j++) {
                double distance = getDist(nodes[i], nodes[j]);
                Edge edge = new Edge(nodes[i].num, nodes[j].num, distance);
                el.add(edge);
            }
        }
        Collections.sort(el);
        for (Edge curr : el) {
            //Edge curr = pq.poll();
            //io.println(Arrays.toString(parent));
            if (!find(curr.src, curr.dest, parent)) {
                //System.out.println(true);
                stack.add(curr);
                union(curr.src, curr.dest, parent, size);
                //io.println(Arrays.toString(parent));
            }
        }
        //io.println(stack);
        //io.println(Arrays.toString(size));
        for (int i = 1; i < satellites; i++) {
            stack.pop();
            //edges.removeLast();
        }
        io.printf("%.2f", stack.peek().weight);
        io.println();
    }

    static void union(int src, int dest, int[] parent, int[] size) {
        /*while (parent[src] != src) src = parent[src];
        while (parent[dest] != dest) dest = parent[dest];
        if (size[src] < size[dest]) {
            parent[src] = parent[dest];
            size[dest] += size[src];
        } else {
            parent[dest] = parent[src];
            size[src] += size[dest];
        }
        src = findRoot(src, parent);
        dest = findRoot(dest, parent);
        if (src == dest) return;
        parent[src] = dest;*/
        int temp = parent[dest];
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == temp) parent[i] = parent[src];
        }
    }

    static boolean find(int src, int dest, int[] parent) {
        return parent[src] == parent[dest];
        //return findRoot(src, parent) == findRoot(dest, parent);
    }

    static int findRoot(int root, int[] parent) {
        while (parent[root] != root) {
            parent[root] = parent[parent[root]];
            root = parent[root];
        }
        return root;
        /*if (parent[root] == -1) return root;
        parent[root] = findRoot(parent[root], parent);
        return parent[root];*/
    }

    static double getDist(Node one, Node two) {
        int horizontal = one.x - two.x;
        int vertical = one.y - two.y;
        return Math.sqrt(Math.pow(horizontal, 2) + Math.pow(vertical, 2));
    }

    static class Node {

        int num;
        int x;
        int y;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    static class Edge implements Comparable<Edge>{
        int src;
        int dest; 
        double weight;

        public Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight < other.weight ? -1 : 1;
        }

        public String toString() {
            return "(" + this.src + ", " + this.dest + ", " + this.weight + ")";
        }
    }
}