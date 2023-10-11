# @source: https://school.programmers.co.kr/learn/courses/30/lessons/120848 (팩토리얼)
# @classfication: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (O)
def solution(n):
    y = 1
    num = 0

    while n >= y:
        num += 1
        y *= num

    return num if n == y else num - 1
