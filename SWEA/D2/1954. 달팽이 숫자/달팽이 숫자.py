t = int(input())

def check_in_range(x,y,n):
    return 0 <= x < n and 0 <= y <= n

for test_case in range(1, t+1):
    n = int(input())

    board = [[0]*n for _ in range(n)]

    cnt = 1
    phase = 0
    i,j = 0, -1
    while (phase != n*2 -1):
        # 오른쪽으로
        if phase % 4 == 0:
            for _ in range(n):
                j += 1
                if check_in_range(i,j,n):
                    if board[i][j] != 0:
                        j -= 1
                        break
                    else:
                        board[i][j] = cnt
                        cnt += 1
                else:
                    j -= 1
            phase += 1
        # 아래로
        elif phase % 4 == 1:
            for _ in range(n):
                i += 1
                if check_in_range(i,j,n):
                    if board[i][j] != 0:
                        i -= 1
                        break
                    else:
                        board[i][j] = cnt
                        cnt += 1
                else:
                    i -= 1
            phase += 1
        # 왼쪽으로
        elif phase % 4 == 2:
            for _ in range(n):
                j -= 1
                if check_in_range(i,j,n):
                    if board[i][j] != 0:
                        j += 1
                        break
                    else:
                        board[i][j] = cnt
                        cnt += 1
                else:
                    j += 1
            phase += 1
        # 위로
        elif phase % 4 == 3:
            for _ in range(n):
                i -= 1
                if check_in_range(i,j,n):
                    if board[i][j] != 0:
                        i += 1
                        break
                    else:
                        board[i][j] = cnt
                        cnt += 1
                else:
                    i += 1
            phase += 1
    print("#{}".format(test_case))

    for arr in board:
        print(*arr)