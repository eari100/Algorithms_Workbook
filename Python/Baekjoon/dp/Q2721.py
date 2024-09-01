# @source: https://www.acmicpc.net/problem/2721 (삼각수의 합)
# @classification: dp
# @문제 푼 날짜 (자력솔): 24.09.01 (O)
t = int(input())
answer = []

for _ in range(t):
    n = int(input())
    dp1 = [0] * (n + 1)
    dp1[0] = 1
    dp2 = [0] * (n + 1)

    for i in range(1, n+1):
        dp1[i] = dp1[i-1] + i + 1
        dp2[i] = dp2[i-1] + (i * dp1[i])

    answer.append(str(dp2[n]))

print('\n'.join(answer))