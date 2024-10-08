import sys
input = sys.stdin.readline

n,s,m = map(int,input().split())

volume_diff = list(map(int,input().rstrip().split()))

dp = [[0] * (m+1) for _ in range(n+1)]
dp[0][s] = 1

for i in range(n):
    for j in range(m+1):
        if dp[i][j] == 1:
            if j+volume_diff[i] <= m:
                dp[i+1][j+volume_diff[i]] = 1
            if j-volume_diff[i] >= 0:
                dp[i+1][j-volume_diff[i]] = 1

ans = -1

for i in range(m,-1,-1):
    if dp[n][i] == 1:
        ans = i
        break
print(ans)