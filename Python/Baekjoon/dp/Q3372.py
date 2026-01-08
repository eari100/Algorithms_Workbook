# @source: https://www.acmicpc.net/problem/3372 (보드 점프)
# @classification: dp
# @문제 푼 날짜 (자력으로 풂?): 26.01.08 (O)

n = int(input())
jump_power = [[0 for _ in range(n)] for _ in range(n)]
dp = [[0 for _ in range(n)]  for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    jump_power[i] = list(map(int, input().split()))

for i in range(n):
    for j in range(n):
        if jump_power[i][j] > 0:
            w = j + jump_power[i][j]
            if w < n:
                dp[i][w] += dp[i][j]

            h = i + jump_power[i][j]
            if h < n:
                dp[h][j] += dp[i][j]

print(dp[n-1][n-1])
