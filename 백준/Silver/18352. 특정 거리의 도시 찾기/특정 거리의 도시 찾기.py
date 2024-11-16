import heapq

n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

distance = [int(1e9) for _ in range(n+1)]

queue = []
heapq.heappush(queue, (0, x))
distance[x] = 0

while queue:
    dist, current = heapq.heappop(queue)

    for node in graph[current]:
        cost = dist + 1
        if cost < distance[node]:
            distance[node] = cost
            heapq.heappush(queue, (cost, node))
cnt = 0
for i in range(1, n+1):
    if distance[i] == k:
        cnt += 1
        print(i)

if cnt == 0:
    print(-1)