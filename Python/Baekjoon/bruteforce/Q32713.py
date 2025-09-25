# @source: https://www.acmicpc.net/problem/32713 (숫자 POP)
# @classification: implementation
# @문제 푼 날짜 (자력솔): 25.09.25 (O)
n, k = map(int, input().split())
_max = 1
nums = list(map(int, input().split()))

for i in range(n-1):
    _len = 1
    skip = k
    for j in range(i+1, n):
        if nums[i] != nums[j]:
            if skip > 0:
                skip -= 1
            else:
                break
        else:
            _len += 1
    _max = max(_max, _len)

print(_max)
