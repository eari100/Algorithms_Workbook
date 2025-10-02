# @source: https://www.acmicpc.net/problem/17390 (이건 꼭 풀어야 해!)
# @classification: prefix sum
# @문제 푼 날짜 (자력으로 풂?): 25.10.02 (O)
import sys

n, m = map(int, sys.stdin.readline().split())
nums = sorted(list(map(int, sys.stdin.readline().split())))
sums = [0] * len(nums)
sums[0] = nums[0]

for i in range(1, len(nums)):
    sums[i] = sums[i-1] + nums[i]

for i in range(m):
    l, r = map(int, sys.stdin.readline().split())
    print(sums[r-1] - ( 0 if l == 1 else sums[l-2] ))