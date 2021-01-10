#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

#define umap unordered_map

int main() {
    umap<string, vector<string> > adj;
    umap<string, int> inDegree;
    int edges;
    cin >> edges;
    for (int i = 0; i < edges; i++) {
        string src, dest;
        cin >> src >> dest;
        if (adj.count(dest) == 0) {
            vector<string> lst;
            lst.push_back(src);
            adj[dest] = lst;
        } else {
            adj[dest].push_back(src);
        }
        if (inDegree.count(src) == 0) {
            inDegree[src] = 1;
        } else {
            inDegree[src]++;
        } 
        if (inDegree.count(dest) == 0) {
            inDegree[dest] = 0;
        }
    }
    queue<string> q;
    for (auto it : inDegree) {
        if (it.second == 0) {
            q.push(it.first);
        }
    }
    while (!q.empty()) {
        string curr = q.front();
        q.pop();
        inDegree[curr]--;
        for (string s : adj[curr]) {
            inDegree[s]--;
            if (inDegree[s] == 0) {
                q.push(s);
            }
        }
    }
    string query;
    while (cin >> query) {
        if (inDegree[query] > 0) {
            cout << query << " " << "safe" << endl;
        } else {
            cout << query << " " << "trapped" << endl;
        }
    }
}