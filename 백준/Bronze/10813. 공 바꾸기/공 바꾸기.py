n, m = map(int, input().split())

arr = [i+1 for i in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    arr[a-1], arr[b-1] = arr[b-1], arr[a-1]

print(*arr)