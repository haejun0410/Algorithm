t = int(input())
for test_case in range(1, t+1):
    n = int(input())

    divider_list = [2, 3, 5, 7, 11]
    answer = []

    for i in range(5):
        divider = divider_list[i]
        cnt = 0
        flag = True
        while flag:
            if n % divider != 0:
                flag = False
            else:
                n = n // divider
                cnt += 1
        answer.append(cnt)
    print("#{}".format(test_case),end = " ")
    print(*answer)