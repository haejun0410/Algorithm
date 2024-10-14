import sys
input = sys.stdin.readline

n,k = map(int,input().split())
nums = list(map(int,input().split()))

prefix = [0 for _ in range(n+1)]

for i in range(1, n+1):
    prefix[i] = prefix[i-1] + nums[i-1]

answer = []
for i in range(k,n+1):
    answer.append(prefix[i] - prefix[i-k])

print(max(answer))