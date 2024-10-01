group = 1
while True:
    n = int(input())
    if n == 0:
        break
    messages = []
    for _ in range(n):
        message = input().split()
        messages.append(message)
    print(f'Group {group}')
    flag = True
    for i in range(n):
        if 'N' in messages[i][1:]:
            flag = False
            for j in range(1, n):
                if messages[i][j] == 'N':
                    print(f'{messages[i-j][0]} was nasty about {messages[i][0]}')
    if flag:
        print('Nobody was nasty')
    print()
    group += 1