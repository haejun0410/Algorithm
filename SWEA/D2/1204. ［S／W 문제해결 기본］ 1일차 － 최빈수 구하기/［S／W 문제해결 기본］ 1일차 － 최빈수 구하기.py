t = int(input())

for test_case in range(1, t+1):
    test_number = int(input())
    nums = list(map(int, input().split()))
    num_count = [0 for _ in range(101)]

    for num in nums:
        num_count[num] += 1
    num_count.reverse()
    max_index = 100 - num_count.index(max(num_count))

    print("#{} {}".format(test_number, max_index))