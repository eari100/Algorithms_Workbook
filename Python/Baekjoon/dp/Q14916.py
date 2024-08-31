# @source: https://www.acmicpc.net/problem/14916 (거스름돈)
# @classification: dp
# @문제 푼 날짜 (자력솔): 24.08.31 (X, 계산 실수)
n = int(input())
inf = 100_000
dp = [inf] * (n + 1)
dp[0] = 0

for i in range(2, n+1):
    if i >= 2:
        dp[i] = min(dp[i], dp[i - 2] + 1)
    if i >= 5:
        dp[i] = min(dp[i], dp[i - 5] + 1)

print(-1 if dp[n] == inf else dp[n])