# @source: https://www.acmicpc.net/problem/25416 (빠른 숫자 탐색)
# @classification: bfs
# @문제 푼 날짜 (자력솔): 24.08.25 (O)
_map = [list(map(int, input().split(' '))) for _ in range(5)]
s_x, s_y = map(int, input().split(' '))
_dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]

visited = [[False] * 5 for _ in range(5)]
visited[s_x][s_y] = True
queue = [[s_x, s_y, 0]]

answer = -1

while len(queue) > 0:
    _pop = queue.pop(0)
    x1, y1, dist1 = _pop[0], _pop[1], _pop[2]

    if _map[x1][y1] == 1:
        answer = dist1
        break

    for d in _dir:
        x2, y2, dist2 = x1 + d[0], y1 + d[1], dist1 + 1

        if x2 < 0 or x2 >= 5 or y2 < 0 or y2 >= 5 or visited[x2][y2] or _map[x2][y2] == -1:
            continue

        visited[x2][y2] = True
        queue.append([x2, y2, dist2])

print(answer)