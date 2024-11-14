t = int(input())


def checkValid(y, x):
    return 0 <= y < h and 0 <= x < w


for test_case in range(1, t+1):
    h, w = map(int, input().split())
    board = [list(input()) for _ in range(h)]

    tank_pos = ['<', 'v', '>', '^']
    fire_pos = [[0, -1], [1, 0], [0, 1], [-1, 0]]
    for i in range(h):
        for j in range(w):
            if board[i][j] in ['<', 'v', '>', '^']:
                tank = (i, j)
                current_direction = tank_pos.index(board[i][j])
    n = int(input())
    commands = list(input())

    for command in commands:
        tank_y, tank_x = tank
        if command == "U":
            current_direction = 3
            if checkValid(tank_y-1, tank_x) and board[tank_y-1][tank_x] == ".":
                board[tank_y][tank_x] = "."
                tank = (tank_y-1, tank_x)
                board[tank_y - 1][tank_x] = "^"
            else:
                board[tank_y][tank_x] = "^"
        elif command == "D":
            current_direction = 1
            if checkValid(tank_y+1, tank_x) and board[tank_y+1][tank_x] == ".":
                board[tank_y][tank_x] = "."
                tank = (tank_y + 1, tank_x)
                board[tank_y + 1][tank_x] = "v"
            else:
                board[tank_y][tank_x] = "v"
        elif command == "L":
            current_direction = 0
            if checkValid(tank_y, tank_x-1) and board[tank_y][tank_x-1] == ".":
                board[tank_y][tank_x] = "."
                tank = (tank_y, tank_x-1)
                board[tank_y][tank_x-1] = "<"
            else:
                board[tank_y][tank_x] = "<"
        elif command == "R":
            current_direction = 2
            if checkValid(tank_y, tank_x+1) and board[tank_y][tank_x+1] == ".":
                board[tank_y][tank_x] = "."
                tank = (tank_y, tank_x+1)
                board[tank_y][tank_x+1] = ">"
            else:
                board[tank_y][tank_x] = ">"
        elif command == "S":
            flag = True
            while flag:
                tank_y, tank_x = tank_y+fire_pos[current_direction][0], tank_x+fire_pos[current_direction][1]
                if not checkValid(tank_y, tank_x):
                    flag = False
                elif board[tank_y][tank_x] == "." or board[tank_y][tank_x] == "-":
                    continue
                elif board[tank_y][tank_x] == "*":
                    board[tank_y][tank_x] = "."
                    flag = False
                elif board[tank_y][tank_x] == "#":
                    flag = False
    print("#{} ".format(test_case), end = "")
    for i in range(h):
        for j in range(w):
            print(board[i][j], end = "")
        print()