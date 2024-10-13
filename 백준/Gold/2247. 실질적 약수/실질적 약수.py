import sys
input = sys.stdin.readline

n = int(input())

answer = 0

for i in range(2,n//2+1):
    answer += (n//i -1)*i

print(answer%1000000)