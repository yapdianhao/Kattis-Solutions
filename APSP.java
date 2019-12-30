import java.util.Arrays;

class APSP {

    static Kattio io = new Kattio(System.in);
    static int MAX = (int) Math.pow(10, 9);

    public static void main(String args[]) {
        int nodes = io.getInt();
        int edges = io.getInt();
        int queries = io.getInt();
        while (nodes != 0 || edges != 0 || queries != 0) {
            solve(nodes, edges, queries);
            nodes = io.getInt();
            edges = io.getInt();
            queries = io.getInt();
        }
        io.close();
    }

    static void solve(int nodes, int edges, int queries) {
        int[][] graph = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = MAX;
                }
            }
        }
        /*for (int i = 0; i < nodes; i++) {
            io.println(Arrays.toString(graph[i]));
        }*/
        for (int i = 0; i < edges; i++) {
            int src = io.getInt();
            int dest = io.getInt();
            int weight = io.getInt();
            graph[src][dest] = Math.min(weight, graph[src][dest]);
        }
        for (int k = 0; k < nodes; k++) {
            for (int v = 0; v < nodes; v++) {
                for (int w = 0; w < nodes; w++) {
                    if (graph[v][k] < MAX && graph[k][w] < MAX) { // ?
                        if (graph[v][w] > graph[v][k] + graph[k][w]) {
                            graph[v][w] = graph[v][k] + graph[k][w];
                        }
                    }
                }
            }
        }
        for (int k = 0; k < nodes; k++) {
            for (int v = 0; v < nodes; v++) {
                for (int w = 0; w < nodes; w++) {
                    if (graph[k][k] < 0 && graph[v][k] != MAX && graph[k][w] != MAX) { //?
                        graph[v][w] = -MAX;
                    }
                }
            }
        }
        for (int i = 0; i < queries; i++) {
            int src = io.getInt();
            int dest = io.getInt();
            if (graph[src][dest] == MAX) {
                io.println("Impossible");
            } else if (graph[src][dest] == -MAX) {
                io.println("-Infinity");
            } else {
                io.println(graph[src][dest]);
            }
        }
        io.println();
    }
}