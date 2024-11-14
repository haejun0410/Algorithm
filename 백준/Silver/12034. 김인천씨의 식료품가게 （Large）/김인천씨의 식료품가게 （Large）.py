from collections import deque

t = int(input())

for test_case in range(1, t+1):
    n = int(input())
    queue = deque(list(map(int, input().split())))
    queue.reverse()
    answer = []

    while queue:
        price = queue.popleft()
        temp = price//4*3
        answer.append(temp)
        queue.remove(temp)

    answer.reverse()
    print("Case #{}: ".format(test_case),end = "")
    print(*answer)