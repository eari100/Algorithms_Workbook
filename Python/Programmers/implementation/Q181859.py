# @source: https://school.programmers.co.kr/learn/courses/30/lessons/181859?language=python3 (배열 만들기 6)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.09 (O)
# todo: stack 으로 풀어볼 것
def solution(arr):
    answer = []

    for i in arr:
        if len(answer) == 0:
            answer.append(i)
        elif answer[-1] == i:
            del answer[-1]
        elif answer[-1] != i:
            answer.append(i)

    return answer or [-1]