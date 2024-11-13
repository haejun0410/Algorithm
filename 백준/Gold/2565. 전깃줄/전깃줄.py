n = int(input())

lines = [list(map(int, input().split())) for _ in range(n)]
lines.sort()

dp = [1 for _ in range(n)]

for i in range(1, n):
    for j in range(i):
        if lines[i][1] > lines[j][1]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))