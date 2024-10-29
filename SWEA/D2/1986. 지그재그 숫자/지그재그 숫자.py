t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    if n%2 == 0:
        answer = -(n//2)
    else:
        answer = (n+1)//2
    print("#{} {}".format(test_case, answer))
        