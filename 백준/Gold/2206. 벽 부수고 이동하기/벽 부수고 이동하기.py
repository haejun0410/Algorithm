import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
map = [list(input().strip()) for _ in range(n)]
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def check(a, b, n, m):
    return 0 <= a < n and 0 <= b < m

def bfs():
    visited = [[[False] * 2 for _ in range(m)] for _ in range(n)]
    queue = deque([(0, 0, 0, 1)])  # x, y, 벽 부쉈는지 여부, 현재 거리
    
    while queue:
        x, y, broken, dist = queue.popleft()
        print(x,y,broken,dist)
        if x == n - 1 and y == m - 1:
            return dist
        
        for d in direction:
            nx = x + d[0]
            ny = y + d[1]
            
            if check(nx, ny, n, m):
                if map[nx][ny] == '0' and not visited[nx][ny][broken]:
                    visited[nx][ny][broken] = True
                    queue.append((nx, ny, broken, dist + 1))
                
                elif map[nx][ny] == '1' and not broken:
                    visited[nx][ny][1] = True
                    queue.append((nx, ny, 1, dist + 1))
    return -1
print(bfs())
