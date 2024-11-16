import heapq

cnt = 0
INF = int(1e9)

def checkValid(y, x):
    return 0 <= y < n and 0 <= x < n

def dijkstra(y, x, cost):
    queue = []
    heapq.heappush(queue, (cost, y, x))
    distance[y][x] = graph[y][x]

    while queue:
        weight, y, x = heapq.heappop(queue)
        if y == n-1 and x == n-1:
            print("Problem {}: {}".format(cnt, distance[-1][-1]))
            return
        if weight > distance[y][x]:
            continue
        for dy, dx in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            ny, nx = y + dy, x + dx
            if checkValid(ny, nx):
                new_cost = weight + graph[ny][nx]
                if new_cost < distance[ny][nx]:
                    distance[ny][nx] = new_cost
                    heapq.heappush(queue, (new_cost, ny, nx))

while True:
    n = int(input())
    if n == 0:
        break
    else:
        cnt += 1
    graph = [list(map(int, input().split())) for _ in range(n)]
    distance = [[INF for _ in range(n)] for _ in range(n)]
    dijkstra(0, 0, graph[0][0])
