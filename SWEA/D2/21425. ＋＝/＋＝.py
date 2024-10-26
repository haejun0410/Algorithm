T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a,b,n = map(int,input().split())
    cnt = 0
    while ( a <= n or b <= n):
        if a > b:
            b += a
        else:
            a += b
        cnt += 1
    print(cnt-1)
