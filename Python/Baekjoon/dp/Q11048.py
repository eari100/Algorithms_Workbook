N, M = map(int, input().split())
prevPoints = [[-1, -1], [-1, 0], [0, -1]]
memo = []

for _ in range(N):
    memo.append(list(map(int, input().split())))

for x in range(N):
    for y in range(M):
        temp = 0
        for prevPoint in prevPoints:
            x2 = x + prevPoint[0]
            y2 = y + prevPoint[1]

            if x2 < 0 or y2 < 0:
                continue

            temp = max(temp, memo[x2][y2])

        memo[x][y] += temp

print(memo[N - 1][M - 1])
