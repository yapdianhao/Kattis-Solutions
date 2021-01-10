#include <iostream>

using namespace std;

void bellmanFord(int graph[][3], int nodes, int edges) {
    int dist[nodes];
    for (int i = 0; i < nodes; i++) {
        dist[i] = INT_MAX;
    }
    dist[0] = 0;
    for (int i = 0; i < nodes; i++) {
        for (int j = 0; j < edges; j++) {
            int src = graph[j][0];
            int dest = graph[j][1];
            int w = graph[j][2];
            if ((dist[dest] > dist[src] + w) && dist[src] != INT_MAX) {
                dist[dest] = dist[src] + w;
            }
        }
    }
    for (int i = 0; i < nodes; i++) {
        cout << "dist " << i << " " << dist[i] << endl;
    }
}

void solve(int nodes, int edges) {
    int adj[edges][3];
    for (int i = 0; i < edges; i++) {
        int src;
        int dest;
        int w;
        cin >> src >> dest >> w;
        adj[i][0] = src - 1;
        adj[i][1] = dest - 1;
        adj[i][2] = w;
    }
    bellmanFord(adj, nodes, edges);
    // for (int i = 0; i < edges; i++) {
    //     cout << adj[i][0] << " " << adj[i][1] << " " << adj[i][2] << endl;
    // }
}

int main() {
    int nodes;
    int edges;
    cin >> nodes;
    while (nodes != 0) {
        cin >> edges;
        solve(nodes, edges);
        //cout << "++++++++++++++++++" << endl;
        cin >> nodes;
    }
}