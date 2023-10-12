# @source: https://school.programmers.co.kr/learn/courses/30/lessons/142086 (가장 가까운 같은 글자)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (O)

def solution(s):
    answer = []

    for i in range(len(s)):
        loop_flag = False
        for j in range(i-1, -1, -1):
            if s[i] == s[j]:
                loop_flag = True
                answer.append(i-j)
                break

        if not loop_flag:
            answer.append(-1)

    return answer
