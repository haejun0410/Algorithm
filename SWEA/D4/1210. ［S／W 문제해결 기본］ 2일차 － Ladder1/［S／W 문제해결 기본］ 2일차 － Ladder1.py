from collections import deque

t = 10

def checkValid(x,y):
    return 0<=x<100 and 0<=y<100

for _ in range(1, t+1):
    test_case = int(input())
    map = []
    queue = deque()
    visited = [[0]*100 for _ in range(100)]
    for _ in range(99):
        map.append(list(input().split()))
    start_y = 99
    arr = list(input().split())
    start_x = arr.index("2")
    map.append(arr)

    # 오른쪽으로 / 왼쪽으로 / 위로
    direction = [(0,1), (0,-1), (-1,0)]

    visited[start_y][start_x] = 1
    queue.append((start_y, start_x))

    while queue:
        for _ in range(len(queue)):
            cy,cx = queue.popleft()
            if cy == 0:
                print("#{} {}".format(test_case, cx))
                break

            flag = 1
            for dy, dx in direction:
                ny, nx = cy + dy , cx + dx
                if flag:
                    if checkValid(ny,nx):
                        if map[ny][nx] == "1" and not visited[ny][nx]:
                            visited[ny][nx] = 1
                            queue.append((ny,nx))
                            flag = 0


