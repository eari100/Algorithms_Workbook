# @source: https://school.programmers.co.kr/learn/courses/30/lessons/135808
# @classfication: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (O)
# @참고용: https://school.programmers.co.kr/learn/courses/30/lessons/135808/solution_groups?language=python3
def solution(k, m, score):
    answer = 0
    score.sort()

    for i in range(len(score)-m, -1, -m):
        answer += score[i] * m

    return answer
