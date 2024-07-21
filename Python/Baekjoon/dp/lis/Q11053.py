# @source: https://www.acmicpc.net/problem/11053 (가장 긴 증가하는 부분 수열)
# @classification: lis
# @문제 푼 날짜 (자력솔): 24.07.21 (X)
n = int(input())
_list = list(map(int, input().split()))
dp = [1] * n

for i in range(len(_list)):
    _next = _list[i]

    for j in range(i):
        _prev = _list[j]

        if _prev < _next:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))
