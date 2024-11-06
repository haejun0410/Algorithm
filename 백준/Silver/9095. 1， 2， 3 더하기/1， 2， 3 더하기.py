t = int(input())
dp = [0 for _ in range(13)]
dp[1] = 1
dp[2] = 2
dp[3] = 4

for idx in range(4, 13):
    dp[idx] = dp[idx-1] + dp[idx-2] + dp[idx-3]
for _ in range(t):
    n = int(input())
    print(dp[n])