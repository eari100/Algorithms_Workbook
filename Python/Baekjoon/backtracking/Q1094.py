# @source: https://www.acmicpc.net/problem/1094 (막대기)
# @classification: backtracking
# @문제 푼 날짜 (자력으로 풂?): 24.12.09 (O)
def bt(nums, index, sum, cnt, y):
    if sum == y:
        return cnt
    elif sum > y:
        return 0

    if index == len(nums):
        return 0

    return max(bt(nums, index+1, sum, cnt, y), bt(nums, index+1, sum + nums[index], cnt + 1, y))

y = int(input())
nums = [64, 32, 16, 8, 4, 2, 1]

print(bt(nums, 0, 0, 0, y))
