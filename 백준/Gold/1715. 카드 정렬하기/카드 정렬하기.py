import heapq
import sys

n = int(input())
list = []
for _ in range(n):
    num = int(sys.stdin.readline())
    heapq.heappush(list, num)
count = 0
while len(list) != 1:
    s1 = heapq.heappop(list)
    s2 = heapq.heappop(list)
    temp = s1+s2
    count += temp
    heapq.heappush(list, temp)

print(count)