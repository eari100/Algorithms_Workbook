# @source: https://www.acmicpc.net/problem/2721 (삼각수의 합)
# @classification: dp
# @문제 푼 날짜 (자력솔): 24.09.01 (O)
t = int(input())
answer = []
dp1 = [1]
dp2 = [0]

for _ in range(t):
    n = int(input())

    for i in range(1, n+1):
        if len(dp1) < i+1:
            dp1.append(dp1[i-1] + i + 1)
            dp2.append(dp2[i-1] + (i * dp1[i]))

    answer.append(str(dp2[n]))

print('\n'.join(answer))