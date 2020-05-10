import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class CrossCountry {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int size = io.getInt();
        int start = io.getInt();
        int end = io.getInt();
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    io.getInt();
                    continue;
                }
                Node node = new Node(j, io.getInt());
                adj.get(i).add(node);
            }
        }
        int MAX = (int) Math.pow(10, 9);
        int[] dist = new int[size];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node source = new Node(start, 0);
        pq.add(source);
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (dist[curr.key] < curr.w) continue;
            for (Node neigh : adj.get(curr.key)) {
                if (dist[neigh.key] > dist[curr.key] + neigh.w) {
                    dist[neigh.key] = dist[curr.key] + neigh.w;
                    pq.add(neigh);
                }
            }
        }
        io.println(dist[end]);
        io.close();
    }

    static class Node implements Comparable<Node> {

        int key;
        int w;

        public Node(int key, int w) {
            this.key = key;
            this.w = w;
        }

        public int compareTo(Node ot) {
            return this.w - ot.w;
        }

        public String toString() {
            return "(" + this.key + ", " + this.w + ")";
        }
    }
}