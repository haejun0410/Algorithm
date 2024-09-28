import sys
input = sys.stdin.readline

n = int(input())

word_list = []
for _ in range(n):
    word_list.append(input().rstrip())

cnt = 0
answer = ""
for index in range(len(word_list[0])):
    temp = word_list[0][index]

    flag = False
    for word in word_list:
        if word[index] != temp:
            cnt += 1
            flag = True
            break
    if not flag:
        for _ in range(cnt):
            answer += "?"
        cnt = 0
        answer += temp
for _ in range(cnt):
    answer += "?"
print(answer)