n = int(input())

cnt = 0
for i in range(1,n-1):
    for j in range(1,n-i):
        k = n-i-j
        if k - j >= 2:
            if i%2 == 0:
                cnt += 1

print(cnt)