import sys
input = sys.stdin.readline

t = int(input())

def getParent(x, parent):
    if parent[x] == x:
        return x
    else:
        parent[x] = getParent(parent[x], parent)
        return parent[x]

def unionParent(a,b,parent):
    a = getParent(a,parent)
    b = getParent(b,parent)

    if a > b:
        parent[b] = a
    else:
        parent[a] = b

def checkParent(a,b,parent):
    return getParent(a,parent) == getParent(b,parent)

for _ in range(t):
    n,m = map(int,input().split())

    edges = []
    for i in range(m):
        a,b = map(int,input().split())
        edges.append((a,b))

    parent = [j for j in range(n+1)]
    
    count = 0

    for a,b, in edges:
        if not checkParent(a,b,parent):
            unionParent(a,b,parent)
            count += 1
    print(count)