n, m = map(int, input().split())
arr = [0 for _ in range(n)]
for i in range(m):
    i, j, k = map(int, input().split())
    for m in range(i, j+1):
        arr[m-1] = k

print(*arr)