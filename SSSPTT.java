import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class SSSPTT {

    static Kattio io = new Kattio(System.in);
    static int MAX = (int) Math.pow(10, 9);

    public static void main(String[] args) {
        int nodes = io.getInt();
        int edges = io.getInt();
        int queries = io.getInt();
        int start = io.getInt();
        while (nodes != 0 || edges != 0 || queries != 0 || start != 0) {
            solve(nodes, edges, queries, start);
            nodes = io.getInt();
            edges = io.getInt();
            queries = io.getInt();
            start = io.getInt();
        }
        io.close();
    }

    static void solve(int nodes, int edges, int queries, int start) {
            List<List<Edge>> adj = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                adj.add(new ArrayList<Edge>());
            }
            for (int i = 0; i < edges; i++) {
                int src = io.getInt();
                int dest = io.getInt();
                int avail = io.getInt();
                int interval = io.getInt();
                int w = io.getInt();
                Edge edge = new Edge(dest, avail, interval, w);
                adj.get(src).add(edge);
            }
            int[] dist = new int[nodes];
            Arrays.fill(dist, MAX);
            dist[start] = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(start, 0, 0, 0));
            //int time = 0;
            while(!pq.isEmpty()) {
                Edge curr = pq.poll();
                if (dist[curr.dest] < curr.w) continue;
                for (Edge neighbour : adj.get(curr.dest)) {
                    int temp = dist[curr.dest];
                    if (neighbour.interval == 0) {
                        if (neighbour.avail < temp) continue;
                        else temp = neighbour.avail;
                    } else {
                        if (neighbour.avail > temp) {
                            temp = neighbour.avail;
                        } else {
                            while (neighbour.avail < temp) {
                                neighbour.avail += neighbour.interval;
                            }
                            temp = neighbour.avail;
                        }
                    }
                    /*if (neighbour.avail < temp && neighbour.interval == 0) continue;
                    if (neighbour.avail < temp) {
                        while (neighbour.avail < temp) {
                            neighbour.avail += neighbour.interval;
                        }
                        temp = neighbour.avail;
                    } else if (neighbour.avail > temp) {
                        temp = neighbour.avail;
                    }*/
                    if (temp + neighbour.w < dist[neighbour.dest]) {
                        dist[neighbour.dest] = temp + neighbour.w;
                        pq.add(new Edge(neighbour.dest, neighbour.avail, neighbour.interval,dist[neighbour.dest]));
                    }
                }
            }
            for (int i = 0; i < queries; i++) {
                int target = io.getInt();
                io.println(dist[target] == MAX ? "Impossible" : dist[target]);
            }
            io.println();
        }

    static class Edge implements Comparable<Edge> {

        //int src;
        int dest;
        int avail;
        int interval;
        int w;

        public Edge(int dest, int avail, int interval, int w) {
            this.dest = dest;
            //this.src = src;
            this.avail = avail;
            this.interval = interval;
            this.w = w;
        }

        public int compareTo(Edge ot) {
            return this.w - ot.w;
        }

        public String toString() {
            return "(" + this.dest + ", " + this.avail + ", " + 
                    this.interval + ", " + this.w + ")";
        }
    }
}
