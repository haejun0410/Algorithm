n, k = map(int, input().split())

arr = [i for i in range(2, n+1)]

cnt = 0
div = 2
flag = True
while flag:
    for i in arr:
        if i % div == 0:
            cnt += 1
            arr.remove(i)
        if cnt == k:
            print(i)
            flag = False
            break
    if len(arr) != 0:
        div = min(arr)