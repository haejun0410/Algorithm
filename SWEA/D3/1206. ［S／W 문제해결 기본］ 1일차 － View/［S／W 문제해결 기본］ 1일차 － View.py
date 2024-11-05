t = 10

for test_case in range(1, t+1):
    n = int(input())
    apartments = list(map(int,input().split()))

    answer = 0

    for i in range(2, n-2):
        current = apartments[i]
        check = [apartments[i-1],apartments[i-2],apartments[i+1],apartments[i+2]]
        max_neighbor = max(check)

        if current > max_neighbor:
            answer += (current-max_neighbor)

    print("#{} {}".format(test_case, answer))
