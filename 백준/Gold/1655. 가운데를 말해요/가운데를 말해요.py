import heapq
import sys

n = int(sys.stdin.readline())
left_heap = []
right_heap = []
for _ in range(n):
    num = int(sys.stdin.readline())
    heapq.heappush(left_heap, -num)
    heapq.heappush(right_heap, -heapq.heappop(left_heap))
    
    if len(right_heap) > len(left_heap):
        heapq.heappush(left_heap, -heapq.heappop(right_heap))
    
    if len(left_heap) > len(right_heap):
        print(-left_heap[0])
    else:
        print(min(-left_heap[0], right_heap[0]))