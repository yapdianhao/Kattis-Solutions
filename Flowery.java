import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

class Flowery {
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int nodes = io.getInt();
        int edges = io.getInt();
        //boolean[] visited = new boolean[nodes];
        //ArrayList<Edge> path = new ArrayList<Edge>();
        List<List<Edge>> path = new ArrayList<>();
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Edge>());
            path.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < edges; i++) {
            int start = io.getInt();
            int end = io.getInt();
            int w = io.getInt();
            if (start == end) continue;
            adj.get(start).add(new Edge(end, w));
            adj.get(end).add(new Edge(start, w));
        }
        int[] dist = new int[nodes];
        //boolean[][] visited = new boolean[nodes][nodes];
        Arrays.fill(dist, (int) Math.pow(10, 9));
        dist[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            //io.println(pq);
            Edge curr = pq.poll();
            if (dist[curr.dest] < curr.w) continue; //io.println(curr.dest);
            for (Edge neighbour : adj.get(curr.dest)) {
                if (dist[neighbour.dest] > dist[curr.dest] + neighbour.w) {
                    //io.println(neighbour + " fuck");
                    path.get(neighbour.dest).clear();
                    //if (neighbour.w == 100) io.println(dist[neighbour.dest] + "fuck");
                    dist[neighbour.dest] = dist[curr.dest] + neighbour.w;
                    pq.add(new Edge(neighbour.dest, dist[neighbour.dest]));
                    /*if (neighbour.w == 2 && curr.dest == 4) {
                        io.println(dist[curr.dest] + ": " + curr.dest + ", " + dist[neighbour.dest] + ": " + neighbour.dest);
                    }*/
                    path.get(neighbour.dest).add(new Edge(curr.dest, neighbour.w));
                } else if (dist[neighbour.dest] == dist[curr.dest] + neighbour.w) {
                    //if (neighbour.w == 2 && curr.dest == 4) io.println(dist[curr.dest]);
                    path.get(neighbour.dest).add(new Edge(curr.dest, neighbour.w));
                }
            }
        }
        boolean[] visited = new boolean[nodes];
        int total = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nodes - 1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited[curr]) continue;
            visited[curr] = true;
            for (Edge neighbour : path.get(curr)) {
                //visited[neighbour.dest] = true;
                //io.println(neighbour.w);
                q.add(neighbour.dest);
                total += neighbour.w;
            }
        }
        /*for (int i = 0; i < nodes; i++) {
            io.println(path.get(i));
        }*/
        //io.println(Arrays.toString(dist));
        io.println(total * 2);
        io.close();
    }

    static class Edge implements Comparable<Edge> {
        //int src;
        int dest;
        int w;

        public Edge(int dest, int w) {
          //this.src = src;
            this.dest = dest;
            this.w = w;
        }

        public int compareTo(Edge other) {
            return this.w - other.w;
        }

        public String toString() {
            return "(" + this.dest + ", " + this.w + ")";
        }
    }
}