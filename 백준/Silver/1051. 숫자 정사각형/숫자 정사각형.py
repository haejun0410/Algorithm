import sys
input = sys.stdin.readline

n,m = map(int,input().split())
max_size = min(n,m)
size = 0
board = [list(map(int,list(input().rstrip()))) for _ in range(n)]

def inCoverage(x,y):
    return 0 <= x < n and 0 <= y < m

for i in range(0,n):
    for j in range(0,m):
        for k in range(0,max_size+1):
            if k > size:
                j2 = j + k
                if inCoverage(i,j2):
                    if board[i][j] == board[i][j2]:
                        if inCoverage(i+k, j) and inCoverage(i+k, j2):
                            if board[i][j] == board[i+k][j] and  board[i][j] == board[i+k][j2]:
                                size = k

print((size+1)**2)

