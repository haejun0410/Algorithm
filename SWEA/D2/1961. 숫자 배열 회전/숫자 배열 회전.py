def rotate(board, n):
    answer = []
    for i in range(n):
        temp = []
        for j in range(n-1, -1, -1):
            temp.append(board[j][i])
        answer.append(temp)
    return answer

t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    board = []
    for i in range(n):
        temp = list(input().split())
        board.append(temp)
    board_90 = rotate(board, n)
    board_180 = rotate(board_90, n)
    board_270 = rotate(board_180, n)
    print("#{}".format(test_case))
    
    for i in range(n):
        print("{} {} {}".format("".join(board_90[i]),"".join(board_180[i]),"".join(board_270[i])))