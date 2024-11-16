from collections import deque

n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

maxi = 0

for y in range(n):
    for x in range(m):  # 여기를 수정: range(n) -> range(m)
        if board[y][x] == 'L':
            visited = [[0 for i in range(m)] for j in range(n)]
            dist = [[0 for i in range(m)] for j in range(n)]

            queue = deque()
            queue.append([y, x])
            visited[y][x] = 1
            while queue:
                ey, ex = queue.popleft()

                for dy, dx in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                    ny, nx = ey + dy, ex + dx
                    if 0 <= ny < n and 0 <= nx < m:
                        if board[ny][nx] == "L":
                            if visited[ny][nx] == 0:
                                visited[ny][nx] = 1
                                dist[ny][nx] = dist[ey][ex] + 1
                                maxi = max(maxi, dist[ny][nx])
                                queue.append([ny, nx])

print(maxi)