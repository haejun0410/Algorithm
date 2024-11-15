t = int(input())

def checkValid(y, x):
    return 0 <= y < n and 0 <= x < n

directions = [[-1, 0], [-1, -1], [0, -1], [1, -1],
              [1, 0], [1, 1], [0, 1], [-1, 1]]

for test_case in range(1, t+1):
    # n : 보드의 크기, m : 돌을 놓는 횟수
    n, m = map(int, input().split())

    board = [[0 for _ in range(n)] for _ in range(n)]

    point = n//2-1
    board[point][point] = 2
    board[point][point+1] = 1
    board[point+1][point] = 1
    board[point+1][point+1] = 2

    for _ in range(m):
        y, x, color = map(int, input().split())
        y -= 1
        x -= 1
        board[y][x] = color
        stack = []

        for pos in directions:
            flag = True
            able = False
            cy, cx = y, x
            while flag:
                cy, cx = cy + pos[0], cx + pos[1]
                if not checkValid(cy, cx):
                    flag = False
                    continue
                if board[cy][cx] == 0:
                    flag = False
                    continue
                if board[cy][cx] != color:
                    stack.append((cy, cx))
                if board[cy][cx] == color:
                    flag = False
                    able = True
                    continue
            if able and len(stack) != 0:
                for l,k in stack:
                    board[l][k] = color
            stack.clear()
    black_cnt = 0
    white_cnt = 0

    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                black_cnt += 1
            elif board[i][j] == 2:
                white_cnt += 1
    print("#{} {} {}".format(test_case, black_cnt, white_cnt))