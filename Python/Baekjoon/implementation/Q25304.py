# @source: https://www.acmicpc.net/problem/25304 (영수증)
money_sum = int(input())
object_cnt = int(input())
cal_money_sum = 0

for _ in range(object_cnt):
    obj, cnt = map(int, input().split())
    cal_money_sum += (obj * cnt)

print('Yes' if money_sum == cal_money_sum else 'No')
