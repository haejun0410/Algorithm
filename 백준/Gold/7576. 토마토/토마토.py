import sys
from collections import deque

m,n = map(int,input().split())

box = []

for _ in range(n):
    arr = list(map(int,sys.stdin.readline().rstrip().split()))
    box.append(arr)

status = True

position = [[+1, 0], [-1, 0],[0, +1], [0, -1]]
count = -1
queue = deque()
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i,j))

while queue:
    for _ in range(len(queue)):
        x,y = queue.popleft()
        for dx,dy in position:
            nx,ny = x+dx, y+dy
            if 0 <= nx < n and 0 <= ny < m and box[nx][ny] == 0: 
                box[nx][ny] = 1
                queue.append((nx,ny))
    count += 1


flag = False
for row in box:
    if 0 in row:
        print(-1)
        flag = True
        break
        
if not flag:
    print(count)