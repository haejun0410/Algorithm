t = int(input())
money_list = [50000, 10000,  5000, 1000, 500, 100, 50, 10]
for test_case in range(1, t+1):
    charge = int(input())
    answer = []
    for money in money_list:
        answer.append(charge//money)
        charge = charge%money
    print("#{}".format(test_case))
    print(*answer)