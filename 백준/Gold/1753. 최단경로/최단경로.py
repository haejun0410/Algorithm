import sys
import heapq

INF = int(1e9)

v,e = map(int,input().split())
graph = [[] for _ in range(v+1)]
k = int(input())
distance = [INF]*(v+1)

for _ in range(e):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append((b,c))


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, now = heapq.heappop(queue)

        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, (cost, i[0]))
dijkstra(k)

for i in range(1,v+1):
    print("INF" if distance[i] is INF else distance[i])