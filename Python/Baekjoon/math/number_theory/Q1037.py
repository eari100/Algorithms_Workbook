# @source:https://www.acmicpc.net/problem/1037 (약수)
# @classfication: number theory
# @문제 푼 날짜 (자력으로 풂?): 23.09.28 (X)
count = int(input())
num_list = list(map(int, input().split()))
_min = min(num_list)
_max = max(num_list)

print(_min * _max)