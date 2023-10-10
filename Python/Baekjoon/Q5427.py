# @source: https://www.acmicpc.net/problem/5427 (불)
# @classfication: bfs
# @문제 푼 날짜 (자력으로 풂?): 23.10.10 (X)

from collections import deque


T = int(input())
result = ''
nx = [-1, 1, 0, 0]
ny = [0, 0, -1, 1]
IMPOSSIBLE = 'IMPOSSIBLE'
answers = ''

for _ in range(T):
    W, H = map(int, input().split())
    fire_que = deque()
    sanggun_que = deque()
    board = []
    answer = -1
    loop_break = False

    for i in range(H):
        row = input()
        board.append(list(row))
        for j in range(W):
            obj = row[j]

            if obj == '@':
                sanggun_que.append([i, j, 1])
            elif obj == '*':
                fire_que.append([i, j])

    while len(fire_que) > 0 or len(sanggun_que) > 0:
        fire_que2 = deque()
        sanggun_que2 = deque()

        while len(fire_que) > 0:
            poll = fire_que.popleft()
            x1, y1 = poll[0], poll[1]

            for i in range(len(nx)):
                x2 = x1 + nx[i]
                y2 = y1 + ny[i]

                if x2 < 0 or x2 >= H or y2 < 0 or y2 >= W:
                    continue

                if board[x2][y2] == '#' or board[x2][y2] == '*':
                    continue

                board[x2][y2] = '*'
                fire_que2.append([x2, y2])

        while len(sanggun_que) > 0:
            poll = sanggun_que.popleft()
            x1, y1, dist1 = poll[0], poll[1], poll[2]

            if x1 == 0 or x1 == H-1 or y1 == 0 or y1 == W-1:
                answer = dist1
                loop_break = True
                break

            for i in range(len(nx)):
                x2 = x1 + nx[i]
                y2 = y1 + ny[i]
                dist2 = dist1 + 1

                if x2 < 0 or x2 >= H or y2 < 0 or y2 >= W:
                    continue

                if board[x2][y2] != '.':
                    continue

                board[x2][y2] = 'x'
                sanggun_que2.append([x2, y2, dist2])

        if loop_break:
            break

        fire_que = fire_que2
        sanggun_que = sanggun_que2

    answers += IMPOSSIBLE if answer == -1 else str(answer)
    answers += '\n'

print(answers)
