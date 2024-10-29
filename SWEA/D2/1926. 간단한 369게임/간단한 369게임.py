n = int(input())

for i in range(1,n+1):
    current_number = str(i)
    cnt = 0
    answer = ""
    for number in current_number:
        if int(number)%3 == 0 and int(number) != 0:
            answer += "-"
            cnt += 1
    if cnt == 0:
        print(i, end = " ")
    else:
        print(answer, end = " ")