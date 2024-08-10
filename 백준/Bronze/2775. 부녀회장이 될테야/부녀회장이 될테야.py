test_case = int(input())

for _ in range(test_case):
    k = int(input())
    n = int(input())
    people = [i for i in range(1,n+1)]

    for a in range(k):
        for b in range(1,n):
            people[b] += people[b-1]
    print(people[-1])