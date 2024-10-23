T = int(input())
month_day = {1:31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    date = input()
    year = date[0:4]
    month = date[4:6]
    day = date[6:]
    if month != '00':
        if int(day) <= month_day[int(month)]:
            print("#{} {}/{}/{}".format(test_case, year, month, day))
        else:
            print("#{} -1".format(test_case))
    else:
        print("#{} -1".format(test_case))