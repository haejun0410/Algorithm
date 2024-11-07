n = int(input())

schedules = [list(map(int,input().split())) for _ in range(n)]

dp = [0 for _ in range(n+1)]

for idx in range(1, n+1):
    dp[idx] = max(dp[idx], dp[idx-1])
    fin_date = idx + schedules[idx-1][0] - 1

    if fin_date <= n:
        dp[fin_date] = max(dp[fin_date], dp[idx-1] + schedules[idx-1][1])


print(max(dp))