# @source: https://www.acmicpc.net/problem/19637 (IF문 좀 대신 써줘)
# @classification: parametric search
# @문제 푼 날짜 (자력으로 풂?): 23.10.12 (X, 힌트 열람)
# todo: bisect_left 로 교체할 것

import sys
input = sys.stdin.readline

style_cnt, character_cnt = map(int, input().split())
styles = {}
style_powers = []


def get_style_name(styles, power):
    str = 0
    end = len(style_powers) - 1
    style_name = ''

    while str <= end:
        mid = (str + end) // 2
        max_power = style_powers[mid]

        if power > max_power:
            str = mid + 1
        elif power < max_power:
            style_name = styles[max_power]
            end = mid - 1
        else:
            style_name = styles[max_power]
            break

    return style_name


for _ in range(style_cnt):
    style_name, max_power = input().split()
    max_power_int = int(max_power)

    if max_power_int not in styles:
        styles[max_power_int] = style_name
        style_powers.append(max_power_int)

for _ in range(character_cnt):
    power = int(input())
    print(get_style_name(styles, power))
