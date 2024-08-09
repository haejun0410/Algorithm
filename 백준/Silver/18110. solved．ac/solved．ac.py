import heapq
import sys

def realRound(num):
    if num - int(num) >= 0.5:
        return int(num) + 1
    else:
        return int(num)
    
heap = []
n = int(input())

for _ in range(n):
    heapq.heappush(heap, int(sys.stdin.readline()))

ceil_num = realRound(n*0.15)
sum_heap = sum(heap)
sum_heap -= sum(heapq.nlargest(ceil_num, heap))
sum_heap -= sum(heapq.nsmallest(ceil_num,heap))

if n==0:
    avg = 0
else:
    avg = realRound(sum_heap/(n-2*ceil_num))
print(avg)

