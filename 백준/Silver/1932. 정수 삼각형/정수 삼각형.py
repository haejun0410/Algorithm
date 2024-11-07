n = int(input())
map = [list(map(int, input().split())) for _ in range(n)]

dp = [[0 for _ in range(n)] for _ in range(n)]

dp[0][0] = map[0][0]

for i in range(1, n):
    for j in range(len(map[i])):
        if j == 0:
            dp[i][j] = dp[i-1][j] + map[i][j]
        elif j == len(map[i]) - 1:
            dp[i][j] = dp[i-1][j-1] + map[i][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + map[i][j]

print(max(dp[-1]))
