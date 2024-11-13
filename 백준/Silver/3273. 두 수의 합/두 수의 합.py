n = int(input())

num_list = list(map(int, input().split()))
num_list.sort()
x = int(input())

start = 0
end = n-1

cnt = 0

while start < end:
    current = num_list[start] + num_list[end]
    if current == x:
        cnt += 1
        start += 1
        end -= 1
    elif current < x:
        start += 1
    else:
        end -= 1

print(cnt)