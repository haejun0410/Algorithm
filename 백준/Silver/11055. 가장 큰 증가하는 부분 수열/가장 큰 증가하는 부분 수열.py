n = int(input())

num_list = list(map(int, input().split()))

dp = num_list[:]
dp[0] = num_list[0]
for i in range(n):
    for j in range(0, i):
        if num_list[i] > num_list[j]:
            dp[i] = max(dp[i], dp[j] + num_list[i])

print(max(dp))