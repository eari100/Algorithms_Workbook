# @source: https://www.acmicpc.net/problem/8394 (8394 악수)
# @classification: dp
# @문제 푼 날짜 (자력솔): 24.08.11 (X, 모듈러 연산 안해줘서 큰 수 연산 메모리 초과)
# @reference: https://asadal.github.io/2021-01-17-%E1%84%8B%E1%85%A1%E1%86%A8%E1%84%89%E1%85%AE/ (점화식 유도)
n = int(input())

dp = [0 for _ in range(n + 1)]

for i in range(1, n + 1):
    if i == 1:
        dp[i] = 1
    elif i == 2:
        dp[i] = 2
    else:
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10 # 모듈러 연산

print(dp[n])