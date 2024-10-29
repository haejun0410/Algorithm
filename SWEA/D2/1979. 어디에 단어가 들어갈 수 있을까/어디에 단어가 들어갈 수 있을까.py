t = int(input())
for test_case in range(1, t+1):
    n, k = map(int,input().split())

    word_map = []
    
    for i in range(n):
        temp = list(map(int,input().split()))
        word_map.append(temp)
    
    answer = 0

    for i in range(n):
        cnt = 0
        for j in range(n):
            if word_map[i][j] == 1:
                cnt += 1
            else:
                if cnt == k:
                    answer += 1
                cnt = 0
        if cnt == k:
            answer += 1
    for i in range(n):
        cnt = 0
        for j in range(n):
            if word_map[j][i] == 1:
                cnt += 1
            else:
                if cnt == k:
                    answer += 1
                cnt = 0
        if cnt == k:
            answer += 1
    print("#{} {}".format(test_case, answer))