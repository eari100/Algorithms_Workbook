# @source: https://www.acmicpc.net/problem/10870 (피보나치 수 5)
# @classification: dp
# @문제 푼 날짜 (자력솔): 24.07.31 (O)

n = int(input())
dp = [0] * ( n + 1 )

for i in range(1, n+1):
    if i == 1:
        dp[1] = 1
    else:
        dp[i] = dp[i-2] + dp[i-1]

print(dp[n])