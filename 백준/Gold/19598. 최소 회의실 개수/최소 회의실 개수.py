import sys
import heapq

n = int(input())

schedules = sorted([list(map(int,input().split())) for _ in range(n)])
h = []

for start, end in schedules:
    if h and h[0] <= start:
        heapq.heappop(h)
    heapq.heappush(h, end)

print(len(h))