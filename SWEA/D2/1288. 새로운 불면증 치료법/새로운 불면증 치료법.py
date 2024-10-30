t = int(input())

for test_case in range(1, t+1):
    n = int(input())
    temp = n
    num_set = set()

    while (len(num_set) != 10):
        for num in str(n):
            num_set.add(num)
        n = n + temp

    print("#{} {}".format(test_case, n-temp))