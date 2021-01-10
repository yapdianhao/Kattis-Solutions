import collections
import sys

def main():
    flights = int(input())
    inDegree = collections.defaultdict(int)
    adj = collections.defaultdict(list)
    trapped = set()
    for i in range(flights):
        start, end = input().split(" ")
        adj[end].append(start)
        inDegree[start] += 1
        inDegree[end] += 0
    queue = []
    for i in inDegree:
        if inDegree[i] == 0:
            queue.append(i)
    while queue:
        curr = queue.pop()
        for neighbour in adj[curr]:
            inDegree[neighbour] -= 1
            if inDegree[neighbour] == 0:
                queue.append(neighbour)
    for query in sys.stdin:
        query = query.rstrip()
        if inDegree[query] > 0:
            print(query + " safe")
        else:
            print(query + " trapped")

main()