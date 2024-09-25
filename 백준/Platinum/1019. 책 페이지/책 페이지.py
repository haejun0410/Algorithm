import sys

ans = [0] * 10
end = int(sys.stdin.readline())

point = 1
start = 1

def cal(x,ans,point):
    while x > 0:
        ans[x % 10] += point
        x //= 10
        

while start <= end:
    while end % 10 != 9:
        cal(end, ans, point)
        end -= 1
    if end < start:
        break
    while start % 10 != 0:
        cal(start, ans, point)
        start += 1
    start //= 10
    end //= 10
    for i in range(10):
        ans[i] += (end - start + 1) * point
    point *= 10

for i in range(10):
    print(ans[i], end= ' ')