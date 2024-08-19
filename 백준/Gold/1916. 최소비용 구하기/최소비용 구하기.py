import sys
import heapq

n = int(input())
m = int(input())

INF = int(1e9)

graph = [[] for _ in range(n+1)]
distance = [INF]*(n+1)

for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append((c,b))

s,e = map(int,input().split())

queue = []

def dijkstra(start):
    heapq.heappush(queue, (0, start))
    while queue:
        cost, current = heapq.heappop(queue)
        if distance[current] < cost:
            continue
        for node in graph[current]:
            new_cost = cost + node[0]
            if distance[node[1]] > new_cost:
                distance[node[1]] = new_cost
                heapq.heappush(queue, (new_cost, node[1]))

dijkstra(s)

print(distance[e])