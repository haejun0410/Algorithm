from collections import deque

a, b = map(int, input().split())

queue = deque()
queue.append((a, 1))

answer = -1
while queue:
    current, cost = queue.pop()

    if current == b:
        answer = cost
        break

    # 2곱하기
    next = current * 2
    if next <= b:
        queue.append((next, cost + 1))
    # 1을 수 오른쪽에 추가
    next = current * 10 + 1
    if next <= b:
        queue.append((next, cost + 1))

print(answer)