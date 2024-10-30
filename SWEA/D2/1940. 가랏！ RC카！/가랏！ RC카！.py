t = int(input())

for test_case in range(1, t+1):
    n = int(input())

    speed = 0
    distance = 0
    for _ in range(n):
        command_list = list(map(int,input().split()))
        command = command_list[0]

        if command == 0:
            distance += speed

        elif command == 1:
            speed += command_list[1]
            distance += speed

        elif command == 2:
            speed -= command_list[1]
            if speed < 0:
                speed = 0
            distance += speed
    print("#{} {}".format(test_case, distance))