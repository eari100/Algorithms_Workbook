# @source: https://www.acmicpc.net/problem/12015 (가장 긴 증가하는 부분 수열 2)
# @classification: lis
# @문제 푼 날짜 (자력솔): 24.08.01 (X)
import sys

_input = sys.stdin.readline

def binary_search(_list, _item):
    _str, end = 0, len(_list) - 1

    while _str <= end:
        mid = ( _str + end ) // 2

        if _list[mid] == _item:
            return mid
        elif _list[mid] < _item:
            _str = mid + 1
        else:
            end = mid - 1

    return _str


N = int(_input())
A = [*map(int, _input().split())]

lis = [A[0]]

for item in A:
    _poll = lis[-1]

    if _poll < item:
        lis.append(item)
    else:
        lis[binary_search(lis, item)] = item

print(len(lis))
