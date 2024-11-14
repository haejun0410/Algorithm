t = 10

for test_case in range(1, t+1):
    test_num = int(input())
    search = input()
    text = input()

    answer = text.count(search)
    print("#{} {}".format(test_num, answer))
