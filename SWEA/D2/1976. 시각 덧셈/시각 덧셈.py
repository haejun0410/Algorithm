t= int(input())
for test_case in range(1, t+1):
    h1,m1,h2,m2 = map(int,input().split())
    temp_m = m1 + m2
    answer_m = temp_m % 60
    add_h = temp_m // 60

    answer_h = (h1+h2+add_h) % 12
    if answer_h == 0:
        answer_h = 12

    print("#{} {} {}".format(test_case, answer_h, answer_m))