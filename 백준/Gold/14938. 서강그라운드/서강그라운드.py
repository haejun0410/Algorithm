import sys
import heapq
input = sys.stdin.readline

INF = int(1e9)

# n:지역의 수 m:수색범위 r:길의 갯수
n,m,r = map(int,input().split())
items = list(map(int,input().split()))

graph = [[INF] * (n+1) for _ in range(n+1)]


for a in range(1, n+1):
	for b in range(1,n+1):
		if a == b:
		    graph[a][b] = 0
		
for _ in range(r):
    a,b,c = map(int,input().split())
    graph[a][b] = c
    graph[b][a] = c


for k in range(1,n+1):
	for i in range(1,n+1):
		for j in range(1,n+1):
			graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

max_value = -1

for node in range(1,n+1):
	sum_cost = 0
	for index in range(1,n+1):
		if graph[node][index] <= m:
			sum_cost += items[index-1]
	if max_value < sum_cost:
		max_value = sum_cost

print(max_value)