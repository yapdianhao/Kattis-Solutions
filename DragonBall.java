import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

class DragonBall {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int nodes = io.getInt();
        int edges = io.getInt();
        int[][] temp = new int[edges][3];
        //boolean[] visited = new boolean[nodes];
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Node>());
        }
        for (int i = 0; i < edges; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = io.getInt();
            }
        }
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for (int i = 0; i < 7; i++) {
            int k = io.getInt() - 1;
            if (ht.containsKey(k)) ht.put(k, ht.get(k) + 1);
            else ht.put(k, 1);
        }
        for (int i = 0; i < edges; i++) {
            int src = temp[i][0] - 1;
            int dest = temp[i][1] - 1;
            int w = temp[i][2];
            if (ht.containsKey(dest)) adj.get(src).add(new Node(src, dest, w, true));
            else adj.get(src).add(new Node(src, dest, w, false));
            if (ht.containsKey(src)) adj.get(dest).add(new Node(dest, src, w, true)); 
            else adj.get(dest).add(new Node(dest, src, w, true));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //visited[0] = true;
        int balls = 0;
        if (ht.containsKey(0)) {
            balls += ht.get(0);
        }
        for (Node n : adj.get(0)) {
            pq.add(n);
        }
        int coins = 0;
        while (!pq.isEmpty() && balls < 7) {
            Node curr = pq.poll();
            io.println(curr);
            //if (visited[curr.dest]) continue;
            if (ht.containsKey(curr.dest)) {
                balls += ht.get(curr.dest);
                io.println("warn " + curr);
            }
            coins += curr.w;
            //visited[curr.dest] = true;
            for (Node neigh : adj.get(curr.dest)) {
                pq.add(neigh);
            }
        }
        io.println(balls < 7 ? -1 : coins);
        io.close();
    }

    static class Node implements Comparable<Node> {

        int src;
        int dest;
        int w;
        boolean hasBalls = false;

        public Node(int src, int dest, int w, boolean hasBalls) {
            this.src = src;
            this.dest = dest;
            this.w = w;
            this.hasBalls = hasBalls;
        }

        public int compareTo(Node ot) {
            if (this.hasBalls && !ot.hasBalls) return -1;
            else return this.w - ot.w;
        }

        public String toString() {
            return "(" + this.src + ", " + this.dest + ", " + this.w + ")";
        }
    }
}