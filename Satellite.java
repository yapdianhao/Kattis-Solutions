import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Satellite {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int dishes = io.getInt();
        Dish[] dishArr = new Dish[dishes];
        for (int i = 0; i < dishes; i++) {
            dishArr[i] = new Dish(io.getInt(), io.getInt(), io.getInt());
        }
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < dishes; i++) {
            adj.add(new ArrayList<>());
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < dishes; i++) {
            for (int j = i + 1; j < dishes; j++) {
                double w = getDist(dishArr[i], dishArr[j]) - dishArr[i].r - dishArr[j].r;
                adj.get(i).add(new Edge(i, j, w));
                adj.get(j).add(new Edge(j, i, w));
            } 
        }
        boolean[] visited = new boolean[dishes];
        visited[0] = true;
        for (Edge edge : adj.get(0)) {
            pq.add(edge);
        }
        double res = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if(visited[curr.dest]) continue;
            res += curr.w;
            visited[curr.dest] = true;
            for (Edge neighbour : adj.get(curr.dest)) {
                if (!visited[neighbour.dest]) pq.add(neighbour);
            }
        }
        io.println(res);
        io.close();
    }

    static double getDist(Dish f, Dish s) {
        int h = f.x - s.x;
        int v = f.y - s.y;
        return Math.sqrt(Math.pow(h, 2) + Math.pow(v, 2));
    }

    static class Dish {
        int x;
        int y;
        int r;

        public Dish(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
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
    }
}