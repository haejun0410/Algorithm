t = int(input())

for test_case in range(1, t+1):
    memory = map(int, list(input()))

    current = 0
    cnt = 0

    for mem in memory:
        if current != mem:
            cnt += 1
            current = (current + 1) % 2
    print("#{} {}".format(test_case, cnt))