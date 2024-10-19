# @source: https://www.acmicpc.net/problem/11320 (삼각 무늬 - 1)
# @classification: math
# @문제 푼 날짜 (자력으로 풂?): 24.10.19 (O)
# todo: 공식으로 풀 수 있음
for _ in range(int(input())):
    a, b = map(int, input().split())

    share = a // b
    remain = a % b

    _len = share + (1 if remain > 0 else 0)
    _dp = [0] * (_len + 1)
    _dp[1] = 1
    answer = 1

    for i in range(2, _len + 1):
        _dp[i] = _dp[i - 1] + 2
        answer += _dp[i]

    print(answer)
