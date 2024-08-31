# @source: https://school.programmers.co.kr/learn/courses/30/lessons/154540 (무인도 여행)
# @classification: bfs
# @문제 푼 날짜 (자력솔): 24.08.31 (O)
from collections import deque


dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def solution(maps):
    answer = []
    n, m = len(maps), len(maps[0])
    visted = [[False] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            _data = maps[i][j]

            if _data == 'X' or visted[i][j]: continue

            _queue = deque()

            days = 0
            item = int(_data)

            _queue.append([i, j])
            days += item
            visted[i][j] = True

            while _queue:
                x1, y1 = _queue.popleft()

                for dx, dy in dirs:
                    x2, y2 = x1 + dx, y1 + dy

                    if x2 < 0 or x2 >= n or y2 < 0 or y2 >= m or visted[x2][y2] or maps[x2][y2] == 'X': continue

                    visted[x2][y2] = True
                    days += int(maps[x2][y2])
                    _queue.append([x2, y2])

            answer.append(days)

    if len(answer) == 0: return [-1]

    answer.sort()

    return answer