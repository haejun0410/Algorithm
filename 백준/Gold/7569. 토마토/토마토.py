import sys
from collections import deque

m,n,h = map(int,input().split())

box = []
for _ in range(h):
    sub_box = []
    for i in range(n):
        arr = list(map(int,sys.stdin.readline().rstrip().split()))
        sub_box.append(arr)
    box.append(sub_box)

queue = deque()

direction = [[1,0,0], [-1,0,0], [0,1,0], [0,-1,0], [0,0,1], [0,0,-1]]

for z in range(h):
    for x in range(n):
        for y in range(m):
            if box[z][x][y] == 1:
                queue.append((z,x,y))

days = -1

while queue:
    days += 1
    for _ in range(len(queue)):
        z,x,y = queue.popleft()
        for c,a,b in direction:
            nz,nx,ny = z+c, x+a, y+b

            if 0<= nz < h and 0<= nx < n and 0<= ny < m and box[nz][nx][ny] == 0:
                box[nz][nx][ny] = 1
                queue.append((nz,nx,ny))
    

flag = False
for z in range(h):
    for x in range(n):
        for y in range(m):
            if box[z][x][y] == 0 and flag is False:
                print(-1)
                flag = True

if not flag:
    print(days)