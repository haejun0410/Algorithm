t = int(input())


for test_case in range(1, t+1):
    n = int(input())
    graph = [list(map(int, list(input()))) for _ in range(n)]

    flag = True
    div = n//2

    answer = 0
    for i in range(n):
        answer += sum(graph[i][div:n-div])

        if not flag:
            div += 1
        if flag:
            div -= 1
            if div == 0:
                flag = False
    print("#{} {}".format(test_case, answer))