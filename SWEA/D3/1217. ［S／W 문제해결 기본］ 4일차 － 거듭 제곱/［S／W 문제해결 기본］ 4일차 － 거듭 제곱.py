t = 10

def recursion(a, b):
    if b == m:
        return a
    else:
        return a * recursion(a, b+1)

for test_case in range(1, t+1):
    test_num = int(input())
    n, m = map(int, input().split())
	
    answer = recursion(n, 1)
    print(f'#{test_num} {answer}')
    