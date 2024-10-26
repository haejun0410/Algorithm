n = int(input())

for test_case in range(1, n+1):
    num = int(input())
    max_value = -1
    answer = ""
    
    for _ in range(num):
        a,b = input().split()
        if int(a) > max_value:
            max_value = int(a)
            answer = b
    print(answer)
            