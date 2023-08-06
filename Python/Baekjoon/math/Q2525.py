# @source: https://www.acmicpc.net/problem/2525 (오븐 시계)
hour, minute = map(int, input().split(' '))
addMinute = int(input())

minute += addMinute
hour += minute // 60

hour %= 24
minute %= 60

print(hour, minute)