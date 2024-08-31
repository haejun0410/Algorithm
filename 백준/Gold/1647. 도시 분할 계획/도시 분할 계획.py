import sys
import heapq
input = sys.stdin.readline

n,m = map(int,input().split())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
min_heap = []

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

visited[1] = True

for edge in graph[1]:
    heapq.heappush(min_heap, edge)

answer = 0
count = 0
max_cost = -1
while min_heap or count < n-1:
    cost, node = heapq.heappop(min_heap)
    if not visited[node]:
        visited[node] = True
        answer += cost
        if cost > max_cost:
            max_cost = cost
        count += 1
        for edge in graph[node]:
            if not visited[edge[1]]:
                heapq.heappush(min_heap, edge)

print(answer-max_cost)