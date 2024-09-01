# @source: https://www.acmicpc.net/problem/11660 (구간 합 구하기 5)
# @classification: dp
# @문제 푼 날짜 (자력솔): 24.09.01 (O)
n, m = map(int, input().split())
dp = [[0] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    _list = list(map(int, input().split()))
    for j in range(1, n+1):
        dp[i][j] = _list[j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]

results = []

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    _sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
    results.append(str(_sum))

print('\n'.join(results)) # 문자열은 불변이기 때문에 리스트에 결과를 모아둔 후 마지막에 문자열로 결합함
