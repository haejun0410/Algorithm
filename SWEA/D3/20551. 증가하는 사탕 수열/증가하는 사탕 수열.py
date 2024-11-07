t = int(input())

for test_case in range(1, t+1):
    candies = list(map(int,input().split()))
    candies.reverse()

    cnt = 0
    for i in range(1, 3):
        if candies[i-1] <= candies[i]:
            temp = candies[i-1] - 1
            if temp == 0:
                cnt = -1
                break
            cnt += candies[i] - temp
            candies[i] = temp

    print("#{} {}".format(test_case, cnt))