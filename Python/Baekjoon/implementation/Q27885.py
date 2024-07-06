# @source: https://www.acmicpc.net/problem/27885 (가희와 열리지 않는 건널목)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 24.07.06 (O)
# todo: 더 좋은 방법으로 풀 것
day_sec = 86400
day = [False] * day_sec
result = 0


def cov_sec(time):
    sec = 0
    h, m, s = map(int, time.split(':'))
    sec += h * 3600
    sec += m * 60
    sec += s

    return sec


def check(sec):
    for i in range(sec, sec+40):
        global day_sec, result
        x = i % day_sec

        if not day[x]:
            day[x] = True
            result += 1


c, h = map(int, input().split())

for i in range(c+h):
    check(cov_sec(input()))

print(day_sec - result)
