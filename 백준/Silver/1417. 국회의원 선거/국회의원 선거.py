import heapq
n = int(input())

dasom = int(input())

else_people = []
if n == 1:
    print(0)
else:
    for _ in range(n-1):
        heapq.heappush(else_people, -int(input()))

    count = 0
    while dasom <= -else_people[0]:
        temp = -heapq.heappop(else_people)
        dasom += 1
        heapq.heappush(else_people, -(temp-1))
        count += 1
    print(count)