import sys
import heapq
input = sys.stdin.readline

INF = int(1e9)
n = int(input())

tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    a,b,c = map(int,input().split())
    tree[a].append((b,c))
    tree[b].append((a,c))

def dijkstra(start):
    distance = [INF for _ in range(n+1)]
    distance[start] = 0
    queue = [(0, start)]

    while queue:
        cost, current = heapq.heappop(queue)
        if cost > distance[current]:
            continue
        for node in tree[current]:
            n_cost = cost + node[1]
            if n_cost < distance[node[0]]:
                distance[node[0]] = n_cost
                heapq.heappush(queue, (n_cost, node[0]))
    
    return distance

temp_distance = dijkstra(1)
max_index = -1
max_value = -1

for i in range(1, n+1):
    if temp_distance[i] > max_value and temp_distance[i] != INF:
        max_index = i
        max_value = temp_distance[i]

temp_distance = dijkstra(max_index)

diameter = -1

for distance in temp_distance:
    if distance > diameter and distance != INF:
        diameter = distance

print(diameter)