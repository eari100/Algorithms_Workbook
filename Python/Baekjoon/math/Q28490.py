# @source: https://www.acmicpc.net/problem/28490 (Area)
largest_size = 0

n = int(input())

for _ in range(n):
    h, w = map(int, input().split())
    size = h * w
    largest_size = max(largest_size, size)

print(largest_size)
