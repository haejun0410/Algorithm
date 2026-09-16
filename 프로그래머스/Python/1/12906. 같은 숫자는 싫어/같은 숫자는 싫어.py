def solution(arr):
    answer = []
    lenAnswer = 1
    answer.append(arr[0])
    for i in range(1,len(arr)):
        if answer[lenAnswer-1] != arr[i]:
            answer.append(arr[i])
            lenAnswer += 1
    return answer