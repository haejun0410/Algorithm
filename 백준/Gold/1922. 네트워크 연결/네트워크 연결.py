import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

edges = []

for _ in range(m):
    a,b,c = map(int,input().split())
    edges.append((a,b,c))

edges.sort(key=lambda x:x[2])

parent = [i for i in range(n+1)]
def getParent(x):
    if parent[x] == x:
        return x
    else:
        parent[x] = getParent(parent[x])
        return parent[x]

def unionParent(a,b):
    a = getParent(a)
    b = getParent(b)

    if a > b:
        parent[b] = a
    else:
        parent[a] = b

def checkParent(a,b):
    return getParent(a) == getParent(b)



count = 0
for a,b,cost in edges:
    if not checkParent(a,b):
        unionParent(a,b)
        count += cost

print(count)
