t = int(input())

for test_case in range(1, t+1):
    n, p = map(int, input().split())

    answer = 0
    for i in range(1, n+1):
        answer += i
        if answer == p:
            answer -= 1
    print(answer)