# @source: https://school.programmers.co.kr/learn/courses/30/lessons/181880 (1로 만들기)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.09 (O)
# todo: 이진법으로 풀어볼 것
def solution(num_list):
    answer = 0

    for num in num_list:
        while num > 1:
            answer += 1
            num //= 2

    return answer
