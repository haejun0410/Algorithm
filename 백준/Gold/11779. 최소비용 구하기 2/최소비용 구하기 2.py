import sys
import heapq
import copy

INF = int(1e9)
n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)
visited_count = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append((c,b))

queue = []

s,e = map(int,input().split())

def dijkstra(start):
    heapq.heappush(queue, (0, start))
    distance[start] = 0
    visited_count[start].append(start)

    while queue:
        dist, current = heapq.heappop(queue)
        if distance[current] < dist:
            continue
        for node in graph[current]:
            cost = dist + node[0]
            if distance[node[1]] > cost:
                distance[node[1]] = cost
                heapq.heappush(queue, (cost, node[1]))
                visited_count[node[1]] = copy.deepcopy(visited_count[current])
                visited_count[node[1]].append(node[1])

dijkstra(s)

print(distance[e])
print(len(visited_count[e]))

for i in visited_count[e]:
    print(i, end = " ")