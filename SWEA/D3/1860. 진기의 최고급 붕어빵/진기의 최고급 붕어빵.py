t = int(input())

for test_case in range(1, t+1):
    n, m, k = map(int, input().split())
    arrival = list(map(int, input().split()))
    arrival.sort()
    idx = 0
    flag = True
    time = 0
    cnt = 0
    for i in range(max(arrival)+1):
        if arrival[idx] == i:
            if cnt > 0:
                cnt -= 1
                idx += 1
            else:
                flag = False
                break
        time += 1
        if time == m:
            cnt += k
            time = 0
    if flag:
        print("#{} {}".format(test_case, "Possible"))
    else:
        print("#{} {}".format(test_case, "Impossible"))