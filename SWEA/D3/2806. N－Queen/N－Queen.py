t = int(input())


def attack(x):
    for i in range(x):
        if dp[i] == dp[x] or (abs(dp[i] - dp[x]) == abs(i-x)):
            return True
    return False


def recursion(idx):
    global cnt

    if idx == n:
        cnt += 1
    else:
        for i in range(n):
            dp[idx] = i
            if not attack(idx):
                recursion(idx+1)


for test_case in range(1, t+1):
    n = int(input())

    dp = [0 for _ in range(n)]
    cnt = 0
    recursion(0)
    print("#{} {}".format(test_case, cnt))