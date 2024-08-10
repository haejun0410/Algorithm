n = int(input())
size = list(map(int,input().split()))
t,p = map(int,input().split())
bundle = 0

for s in size:
    if s == 0:
        continue
    elif s <= t:
        bundle += 1
    elif s%t == 0:
        bundle += s//t
    else:
        bundle += s//t+1

p_bundle = n//p
pen = n%p

print(bundle)
print(p_bundle, pen)