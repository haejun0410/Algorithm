from collections import deque

n = int(input())
m = int(input())

connected = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    connected[a].append(b)
    connected[b].append(a)

visited = [0 for _ in range(n+1)]

stack = deque()
stack.append(1)

while stack:
    current = stack.pop()
    if not visited[current]:
        visited[current] = 1
        for neighbor in connected[current]:
            if not visited[neighbor]:
                stack.append(neighbor)

print(sum(visited) - 1)