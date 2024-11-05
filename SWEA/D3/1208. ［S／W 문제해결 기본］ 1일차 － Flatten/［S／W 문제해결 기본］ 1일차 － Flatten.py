t = 10
for test_case in range(1, t+1):
    dump_count = int(input())

    boxes = list(map(int,input().split()))

    max_height = max(boxes)
    min_height = min(boxes)

    cnt = 0

    while (max_height - min_height <= 1 or cnt != dump_count):
        max_index = boxes.index(max_height)
        min_index = boxes.index(min_height)

        boxes[max_index] -= 1
        boxes[min_index] += 1

        max_height = max(boxes)
        min_height = min(boxes)
        cnt += 1

    print("#{} {}".format(test_case, (max_height - min_height)))