import sys
sys.setrecursionlimit(10 ** 6)

n,m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

dp = [[-1 for _ in range(m)] for _ in range(n)]

def checkValid(y, x):
    return 0 <= y < n and 0 <= x < m

def recursion(y, x):

    if dp[y][x] != -1:
        return dp[y][x]

    if y == n-1 and x == m-1:
        return 1

    route = 0
    for dy, dx in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
        cy, cx = y+dy, x+dx
        if checkValid(cy, cx):
            if graph[y][x] > graph[cy][cx]:
                route += recursion(cy, cx)
    dp[y][x] = route
    return dp[y][x]

recursion(0, 0)

print(max(map(max, dp)))