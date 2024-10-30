t = int(input())

for test_case in range(1, t+1):
    a,b = map(int,input().split());

    if a > b:
        bigger = list(map(int,input().split()))
        smaller = list(map(int,input().split()))
    else:
        smaller = list(map(int, input().split()))
        bigger = list(map(int, input().split()))

    len_smaller = len(smaller)
    len_bigger = len(bigger)

    answer = -9999999
    for j in range(0, len_bigger - len_smaller + 1):
        temp = 0
        for i in range(len_smaller):
            temp += smaller[i] * bigger[i+j]

        if temp > answer:
            answer = temp

    print("#{} {}".format(test_case, answer))

