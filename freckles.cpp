#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#include <algorithm>

using namespace std;

struct edge {
    int src;
    int dest;
    long double weight;
};

long double getDist(pair<long double, long double> p1, pair<long double, long double> p2) {
    return sqrt(pow(p1.first - p2.first, 2) + pow(p1.second - p2.second, 2));
}

struct LighterWeight {
    bool operator() (const edge& lhs, const edge& rhs) const {
        return lhs.weight > rhs.weight;
    }
};

int main() {
    int cases;
    cin >> cases;
    bool start = true;
    while (cases-- > 0) {
        int nodes;
        cin >> nodes;
        if (start) {
            start = false;
        } else {
            cout << endl;
        }
        vector<pair<long double, long double> > arr (nodes);
        for (auto& p : arr) {
            cin >> p.first >> p.second;
        }
        /*for (auto& p : arr) {
            cout << p.first << " " << p.second << endl;
        }*/
        priority_queue<edge, vector<edge>, LighterWeight> pq;
        // build edge list
        vector<vector<edge> > edgeList(nodes);
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                long double dist = getDist(arr[i], arr[j]);
                edge to = {i, j, dist};
                edge from = {j, i, dist};
                edgeList[i].push_back(to);
                edgeList[j].push_back(from);
            }
        }
        long double res = 0;
        bool visited[nodes];
        for (int i = 0; i < nodes; i++) {
            if (i == 0) visited[i] = true;
            else visited[i] = false;
        }
        for (auto& e: edgeList[0]) {
            pq.push(e);
        }
        while (!pq.empty()) {
            edge curr = pq.top();
            //cout << curr.weight << endl;
            pq.pop();
            if (visited[curr.dest]) continue;
            res += curr.weight;
            visited[curr.dest] = true;
            for (auto& e : edgeList[curr.dest]) {
                if (!visited[e.dest]) pq.push(e);
            }
        }
        //cout << edgeList << endl;
        /*for (int i = 0; i < edgeList.size(); i++) {
            for (int j = 0; j < edgeList[i].size(); j++) {
                //cout << edgeList[i][j].src << " " << edgeList[i][j].dest << " " << edgeList[i][j].weight << " " << i << endl;
            }
        }
        for (int i = 0; i < nodes; i++) {
            cout << visited[i] << endl;
        }*/
        cout << fixed;
        cout.precision(2);
        cout << res << endl;
    }
}