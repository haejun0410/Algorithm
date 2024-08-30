import sys
import heapq
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]
visited = [False]*(n+1)
min_heap = []

for i in range(1, n+1):
    c = int(input())
    heapq.heappush(min_heap, (c,i))

for i in range(1, n+1):
    array = list(map(int,input().rstrip().split()))
    for j in range(1, len(array)+1):
        if i != j:
            graph[i].append((array[j-1], j))

answer = 0
count = 0

cost, node = heapq.heappop(min_heap)
visited[node] = True

for edge in graph[node]:
    heapq.heappush(min_heap, edge)
answer += cost

while min_heap and count < n-1:
    cost, node = heapq.heappop(min_heap)
    if not visited[node]:
        visited[node] = True
        answer += cost
        count += 1
        for edge in graph[node]:
            if not visited[edge[1]]:
                heapq.heappush(min_heap, edge)

print(answer)