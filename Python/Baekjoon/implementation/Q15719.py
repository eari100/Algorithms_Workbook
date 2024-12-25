# @source: https://www.acmicpc.net/problem/15719 (중복된 숫자)
# @classification: math
# @문제 푼 날짜 (자력솔): 24.12.25 (X)
import sys

n = int(input())

_sum = n * (n-1) // 2
_str = sys.stdin.readline().rstrip()
_num = ''

for c in _str:
    if c.isdigit():
        _num += c
    else:
        _sum -= int(_num)
        _num = ''

_sum -= int(_num)

print(-_sum)
