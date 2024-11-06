n = int(input())

num_list = list(map(int, input().split()))

dp = [[] for _ in range(n)]

for i in range(n):
    dp[i].append(num_list[i])
    for j in range(0, i):
        if num_list[i] > num_list[j]:
            if len(dp[i]) < len(dp[j]) + 1:
                dp[i] = dp[j].copy()
                dp[i].append(num_list[i])

length = -1
idx = -1

for i in range(0, n):
    if len(dp[i]) > length:
        idx = i
        length = len(dp[i])

print(length)
print(*dp[idx])