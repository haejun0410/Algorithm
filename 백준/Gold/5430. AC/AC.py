from collections import deque

t = int(input())

for _ in range(t):
    p = input()
    n = int(input())
    x = input()[1:-1]
    nums = x.split(',')

    queue = deque(nums)

    reverse = 0
    flag = False

    if n == 0:
        queue = []

    for i in p:
        if i == 'R':
            reverse += 1
        else:
            if len(queue) == 0:
                print('error')
                flag = True
                break
            elif reverse % 2 == 1:
                queue.pop()
            else:
                queue.popleft()

    if not flag:
        if reverse % 2 == 1:
            queue.reverse()
        print('[' + ','.join(queue) + ']')