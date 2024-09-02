import sys
input = sys.stdin.readline

n = int(input())
arr = []
arr_y = []
arr_x = []
answer = [-1]*(n)

for _ in range(n):
    a,b = map(int,input().split())
    arr.append([a,b])
    arr_y.append(b)
    arr_x.append(a)

for y in arr_y:
    for x in arr_x:
        dist = []
        for a,b in arr:
            d = abs(a-x) + abs(b-y)
            dist.append(d)
        dist.sort()
        
        tmp = 0
        
        for i in range(len(dist)):
            d = dist[i]
            tmp += d
            if answer[i] == -1:
                answer[i] = tmp
            else:
                answer[i] = min(tmp, answer[i])

print(*answer)