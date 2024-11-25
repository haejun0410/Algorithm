import sys

input = sys.stdin.readline

n = int(input())
num_list = [list(map(int, input().split())) for _ in range(n)]
num_list.append(num_list[0])

temp1 = 0
for i in range(n):
    temp1 += (num_list[i][0] * num_list[i+1][1])

temp2 = 0
for i in range(1, n+1):
    temp2 += (num_list[i][0] * num_list[i-1][1])

answer = 0.5 * abs(temp1 - temp2)
print(round(answer, 1))