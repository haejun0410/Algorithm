from collections import deque

t = 10

for test_case in range(1, t+1):
    test_number = int(input())

    encoded = deque(list(map(int, input().split())))

    temp = 1

    flag = True

    while flag:
        target = encoded.popleft()
        target -= temp
        if target <= 0:
            target = 0
            flag = False
        else:
            temp += 1
            if temp > 5:
                temp = 1
        encoded.append(target)
    print("#{} ".format(test_number), end = "")
    print(*encoded)