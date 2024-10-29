T = int(input())
for test_case in range(1, T+1):
    word = input()
    start = 0
    end = len(word)-1
    
    flag = False
    while (start < end):
        if word[start] != word[end]:
            flag = True
            break
        else:
            start += 1
            end -= 1
    if flag:
        print("#{} {}".format(test_case, 0))
    else:
        print("#{} {}".format(test_case, 1))