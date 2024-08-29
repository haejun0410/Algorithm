import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

v,e = map(int,input().split())
edges = []

for _ in range(e):
    a,b,c = map(int,input().split())
    edges.append((a,b,c))

edges.sort(key = lambda x:x[2])

parent = [i for i in range(v+1)]

def getParent(x):
    if parent[x] == x:
        return x
    else:
        parent[x] = getParent(parent[x])
        return parent[x]

def sameParent(a,b):
    return getParent(a) == getParent(b)

def unionParent(a,b):
    a = getParent(a)
    b = getParent(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

answer = 0

for a,b,cost in edges:
    if not sameParent(a,b):
        unionParent(a,b)
        answer += cost

print(answer)
