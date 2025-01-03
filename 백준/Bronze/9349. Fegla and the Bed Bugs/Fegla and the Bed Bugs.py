test_case = int(input())

for _ in range(test_case):
    n,k = map(int,input().split())
    remain = n-k
    print(remain//(k-1))