# @source: https://www.acmicpc.net/problem/status/4150 (피보나치 수)
# @classification: math
# @문제 푼 날짜 (자력으로 풂?): 25.12.08 (O)
n = int(input())
a = 1
b = 1
_sum = 1

for i in range(3, n+1):
    _sum = a + b
    a = b
    b = _sum

print(_sum)