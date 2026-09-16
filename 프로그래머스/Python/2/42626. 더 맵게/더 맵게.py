import heapq

def solution(scoville, K):
    answer = 0
    scoville.sort()
    while scoville[0] < K:
        if not scoville or len(scoville) == 1:
            return -1
        else:
            s1 = heapq.heappop(scoville)
            s2 = heapq.heappop(scoville)
            heapq.heappush(scoville, (s1 + s2*2))
            answer += 1
    return answer