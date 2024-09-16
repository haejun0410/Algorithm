import sys
input = sys.stdin.readline

n = int(input())
num_list = []

for _ in range(n):
    a,b,c = map(int,input().split())
    num_list.append((str(a),b,c))

cnt = 0
answer = 0
for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            cnt = 0
            if i!= j and i!=k and j!=k:
                for array in num_list:
                    check = list(array[0])
                    strike = array[1]
                    ball = array[2]

                    strike_cnt = 0
                    ball_cnt = 0

                    if i == int(check[0]):
                        strike_cnt += 1
                    if j == int(check[1]):
                        strike_cnt += 1
                    if k == int(check[2]):
                        strike_cnt += 1
                    
                    if i == int(check[1]) or i == int(check[2]):
                        ball_cnt += 1
                    if j == int(check[0]) or j == int(check[2]):
                        ball_cnt += 1
                    if k == int(check[0]) or k == int(check[1]):
                        ball_cnt += 1

                    if strike_cnt == strike and ball_cnt == ball:
                        cnt += 1

                    if cnt == n:
                        answer += 1

print(answer)
        