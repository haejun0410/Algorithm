from collections import deque

t = int(input())


def checkValid(y, x, l):
    return 0 <= y < l and 0 <= x <l


for test_case in range(1, t+1):
    l = int(input()) # 체스판의 길이
    current_pos = list(map(int, input().split()))
    destination = list(map(int, input().split()))

    movements = [[+2, +1], [-2, +1], [+1, +2], [-1, +2],
                 [+2, -1], [-2, -1], [+1, -2], [-1, -2]]

    queue = deque()
    visited = [[0 for _ in range(l)] for _ in range(l)]
    queue.append(current_pos)

    while queue:
        y, x = queue.popleft()
        if [y, x] == destination:
            print(visited[y][x])
            break
        for move in movements:
            ny, nx = y + move[0], x + move[1]
            if checkValid(ny, nx, l) and not visited[ny][nx]:
                visited[ny][nx] = visited[y][x] + 1
                queue.append((ny, nx))