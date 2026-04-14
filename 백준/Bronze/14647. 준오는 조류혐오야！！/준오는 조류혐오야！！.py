n, m = list(map(int, input().split()))
bingo = [list(map(str,input().split())) for _ in range(n)]

M = 0
A = 0
for i in range(n):
    temp = 0
    for j in range(m):
        bingo[i][j] = list(bingo[i][j])
        temp += bingo[i][j].count('9')
        A += bingo[i][j].count('9')
    M = max(M,temp)

for i in range(m):
    temp = 0
    for j in range(n):
        bingo[j][i] = list(bingo[j][i])
        temp += bingo[j][i].count('9')
        A += bingo[j][i].count('9')
    M = max(M,temp)
    
print(A//2 - M)