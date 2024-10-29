t = int(input())

grade = {0: "A+", 1: "A0", 2:"A-", 3: "B+", 4: "B0", 5: "B-", 6: "C+", 7: "C0", 8: "C-", 9: "D0"}
for test_case in range(1, t+1):
    n, k = map(int,input().split())
    scores = []
    for i in range(n):
        a,b,c = map(int,input().split())
        score = 3.5*a + 4.5*b + 2*c
        scores.append(score)
        if i == k-1:
            target_score = score
    scores.sort()
    scores.reverse()
    rank = scores.index(target_score) // (n//10)
    print("#{} {}".format(test_case, grade[rank]))
