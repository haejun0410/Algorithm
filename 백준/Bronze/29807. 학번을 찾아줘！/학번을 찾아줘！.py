def calculate_student_id(scores):
    result = 0
    
    # 국어와 영어 점수 비교
    if len(scores) >= 3:
        if scores[0] > scores[2]:
            result += (scores[0] - scores[2]) * 508
        else:
            result += (scores[2] - scores[0]) * 108
    
    # 수학과 탐구 점수 비교
    if len(scores) >= 4:
        if scores[1] > scores[3]:
            result += (scores[1] - scores[3]) * 212
        else:
            result += (scores[3] - scores[1]) * 305
    
    # 제2외국어 점수 계산
    if len(scores) == 5:
        result += scores[4] * 707
    
    # 최종 학번 계산
    student_id = result * 4763
    
    return student_id

# 입력 받기
T = int(input())
scores = list(map(int, input().split()))

# 응시하지 않은 과목은 0점 처리
while len(scores) < 5:
    scores.append(0)

student_id = calculate_student_id(scores)
print(student_id)