s = sum(list(map(int, input().split())))
t = sum(list(map(int, input().split())))

print(s if s >= t else t)