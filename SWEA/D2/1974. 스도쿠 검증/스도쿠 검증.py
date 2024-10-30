t = int(input())

for test_case in range(1, t+1):
    board = []
    for _ in range(9):
        temp = list(map(int,input().split()))
        board.append(temp)
    
    flag = True
    # check row
    for i in range(9):
        temp = set()
        for number in board[i]:
            temp.add(number)
        if len(temp) != 9:
            flag = False
    # check column
    if flag:
        for i in range(9):
            temp = set()
            for j in range(9):
                temp.add(board[j][i])
            if len(temp) != 9:
                flag = False
    # check square
    if flag:
        for i in range(0,9,3):
            for j in range(0,9,3):
                temp = set()
                for k in range(i, i+3):
                    for l in range(j, j+3):
                        temp.add(board[l][k])
                if len(temp) != 9:
                    flag = False
    
    if flag:
        print("#{} {}".format(test_case, 1))
    else:
        print("#{} {}".format(test_case, 0))