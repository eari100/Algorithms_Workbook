# @source: https://school.programmers.co.kr/learn/courses/30/lessons/1844 (게임 맵 최단거리)
# @classification: bfs
# @문제 푼 날짜 (자력으로 풂?): 23.10.09 (O)
from collections import deque


def solution(maps):
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    queue = deque([[0, 0, 1]])
    nx = [-1, 1, 0, 0]
    ny = [0, 0, -1, 1]
    answer = 0

    while len(queue) > 0:
        poll = queue.popleft()
        x1 = poll[0]
        y1 = poll[1]
        cost1 = poll[2]

        for i in range(len(nx)):
            x2 = x1 + nx[i]
            y2 = y1 + ny[i]
            cost2 = cost1 + 1

            if x2 < 0 or x2 >= len(maps) or y2 < 0 or y2 >= len(maps[0]):
                continue
            if maps[x2][y2] == 0:
                continue
            if visited[x2][y2]:
                continue

            visited[x2][y2] = True
            queue.append([x2, y2, cost2])

            if x2 == len(maps)-1 and y2 == len(maps[0])-1:
                answer = cost2
                break

    return answer if answer > 0 else -1
