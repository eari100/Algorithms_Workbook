# @source: https://school.programmers.co.kr/learn/courses/30/lessons/42839 (소수 찾기)
# @classification: backtracking
# @문제 푼 날짜 (자력으로 풂?): 23.10.10 (O)

_set = set()
visited = []


def solution(numbers):
    global _set, visited

    visited = [False for _ in range(len(numbers))]
    backtracking(0, numbers, '')

    return len(_set)


def backtracking(depth, numbers, _str):
    if depth == len(numbers):
        return

    for i in range(0, len(numbers)):
        if visited[i]:
            continue

        visited[i] = True

        x = int(_str + numbers[i])
        if is_prime(x):
            global _set
            _set.add(x)

        backtracking(depth+1, numbers, _str + numbers[i])
        visited[i] = False


def is_prime(num):
    if num in (0, 1):
        return False

    r = num**(1/2)

    for i in range(2, int(r)+1):
        if num % i == 0:
            return False

    return True
