# @source: https://school.programmers.co.kr/learn/courses/30/lessons/43163 (단어 변환)
# @classification: dfs
# @문제 푼 날짜 (자력으로 풂?): 23.10.11 (O)
# @더 좋은 코드: https://school.programmers.co.kr/learn/courses/30/lessons/43163/solution_groups?language=python3&type=all
# todo: bfs로 성능향상 시킬 것
answer = 0
stt_words, visited = [], []


def solution(begin, target, words):
    global answer, stt_words, visited
    answer = len(words)+1
    stt_words = words
    visited = [False for _ in range(len(words))]
    dfs(begin, target, 0)

    return 0 if answer == len(words)+1 else answer


def dfs(begin, target, cost):
    if begin == target:
        global answer
        answer = min(answer, cost)
        return

    for i in range(len(stt_words)):
        if visited[i]:
            continue

        diff = 0
        loop_flag = True
        for b, t in zip(begin, stt_words[i]):
            if b != t:
                diff += 1
            if diff == 2:
                loop_flag = False
                break

        if not loop_flag:
            continue

        visited[i] = True
        dfs(stt_words[i], target, cost+1)
        visited[i] = False