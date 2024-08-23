import sys
import heapq

input = sys.stdin.readline

INF = int(1e9)
n,m,x = map(int,input().split())

graph1 = [[] for _ in range(n+1)]
graph2 = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    graph1[a].append((c,b))
    graph2[b].append((c,a))


def dijkstra(start, graph):
    distance = [INF]*(n+1)
    queue = []
    distance[start] = 0
    heapq.heappush(queue, (0, start))

    while queue:
        cost, current = heapq.heappop(queue)
        if distance[current] < cost:
            continue

        for i in graph[current]:
            n_cost = cost + i[0]
            if n_cost < distance[i[1]]:
                distance[i[1]] = n_cost
                heapq.heappush(queue, (n_cost, i[1]))
    return distance

source_to_dest = dijkstra(x, graph2)
dest_to_source = dijkstra(x, graph1)

max_cost = -1
for i in range(1, n+1):
    cost = source_to_dest[i] + dest_to_source[i]
    if cost > max_cost:
        max_cost = cost

print(max_cost)