t = int(input())

for test_case in range(1, t+1):
    print("#{}".format(test_case))
    temp = [0]
    n = int(input())
    print(1)
    for i in range(0, n-1):
        current = []
        current.append(1)
        for j in range(1,i+1):
            current.append(temp[j] + temp[j-1])
        current.append(1)
        temp = current
        print(*current)