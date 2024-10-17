import sys
from collections import deque
input = sys.stdin.readline

r,c = map(int,input().split())

map = []
queue = deque()
visited = [[0]*c for _ in range(r) ]

direction = [(1,0), (0,1), (-1,0), (0,-1)]
for i in range(r):
    map.append(list(input().rstrip()))

# 고슴도치 위치 찾기
for i in range(r):
    if "S" in map[i]:
        sx,sy = (i, map[i].index("S"))
        queue.append((sx,sy))

# 물 위치 찾기
for i in range(r):
    if "*" in map[i]:
        queue.append((i, map[i].index("*")))

# 비버의 굴 위치
for i in range(r):
    if "D" in map[i]:
        bx,by = (i, map[i].index("D"))
        break

def checkValid(x,y):
    return 0 <= x < r and 0 <= y < c

def bfs(x,y):
    visited[x][y] = 1
    while queue:
        for _ in range(len(queue)):
            cx,cy = queue.popleft()
            
            if map[cx][cy] == 'D':
                break
            
            for dx, dy in direction:
                nx, ny = cx + dx, cy + dy
                if checkValid(nx,ny):
                    if map[cx][cy] == 'S' and (map[nx][ny] == '.' or map[nx][ny] == 'D'):
                        visited[nx][ny] = visited[cx][cy] + 1
                        map[nx][ny] = "S"
                        queue.append((nx,ny))
                    elif map[cx][cy] == '*' and (map[nx][ny] == '.' or map[nx][ny] == 'S'):
                        map[nx][ny] = '*'
                        queue.append((nx,ny))

bfs(sx,sy)
if visited[bx][by]:
    print(visited[bx][by] - 1)
else:
    print("KAKTUS")