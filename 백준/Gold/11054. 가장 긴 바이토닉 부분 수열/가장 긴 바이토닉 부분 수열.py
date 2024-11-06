n = int(input())

num_list = list(map(int, input().split()))

# 증가
dp1 = [1 for _ in range(n)]
# 감소
dp2 = [1 for _ in range(n)]

for i in range(n):
    for j in range(0, i):
        if num_list[i] > num_list[j]:
            dp1[i] = max(dp1[i], dp1[j] + 1)

num_list.reverse()

for i in range(n):
    for j in range(0, i):
        if num_list[i] > num_list[j]:
            dp2[i] = max(dp2[i], dp2[j] + 1)
dp2.reverse()

answer = []
for i in range(n):
    answer.append(dp1[i] + dp2[i])

print(max(answer)-1)