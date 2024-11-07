n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

dp = [[0 for _ in range(n)] for _ in range(n)]

def checkValid(y, x):
    return 0 <= y < n and 0 <= x < n

def recursion(y, x):

    if dp[y][x] != 0:
        return dp[y][x]

    for dy, dx in [[1,0],[-1,0],[0,1],[0,-1]]:
        cy, cx = y+dy, x+dx
        if checkValid(cy, cx):
            if graph[y][x] < graph[cy][cx]:
                dp[y][x] = max(dp[y][x], recursion(cy, cx) + 1)

    return dp[y][x]


for i in range(n):
    for j in range(n):
        recursion(i, j)

print(max(map(max, dp)) + 1)