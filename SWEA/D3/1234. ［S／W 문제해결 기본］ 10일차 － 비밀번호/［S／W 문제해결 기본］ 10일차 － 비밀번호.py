t = 10

for test_case in range(1, t+1):
    len_pw, pw = input().split()

    dup_nums = [str(i)*2 for i in range(0, 10)]
    flag = True

    while flag:
        cnt = 0
        for num in dup_nums:
            if num in pw:
                cnt += 1
                pw = pw.replace(num, "")
        if cnt == 0:
            flag = False
    print("#{} {}".format(test_case, pw))