import sys
import heapq
import copy 

INF = int(1e9)

n,m = map(int,input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append((c,b))
    graph[b].append((c,a))

x,y = map(int,input().split())

queue = []
def dijkstra(start):
    heapq.heappush(queue, (0, start))
    distance[start] = 0
    while queue:
        dist, current = heapq.heappop(queue)
        if distance[current] < dist:
            continue
        for node in graph[current]:
            cost = dist + node[0]
            if distance[node[1]] > cost:
                distance[node[1]] = cost
                heapq.heappush(queue, (cost, node[1]))

distance = [INF] * (n+1)
dijkstra(1)
ds = copy.deepcopy(distance)

distance = [INF] * (n+1)
dijkstra(x)
dx = copy.deepcopy(distance)

distance = [INF] * (n+1)
dijkstra(y)
dy = copy.deepcopy(distance)


print(-1 if min(ds[x] + dx[y] + dy[n], ds[y] + dy[x] + dx[n]) >= INF else min(ds[x] + dx[y] + dy[n], ds[y] + dy[x] + dx[n]))