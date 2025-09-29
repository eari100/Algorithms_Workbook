nums = [0] * 5
_sum = 0

for i in range(5):
    nums[i] = int(input())
    _sum += nums[i]

nums.sort()

print(_sum // 5)
print(nums[2])
