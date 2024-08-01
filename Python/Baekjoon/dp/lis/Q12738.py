# @source: https://www.acmicpc.net/problem/12738 (가장 긴 증가하는 부분 수열 3)
# @classification: lis
# @문제 푼 날짜 (자력솔): 24.08.01 ("12015. 가장 긴 증가하는 부분 수열 2"와 동일한 문제)
def binary_search(_list, item):
    start, end = 0, len(_list) - 1

    while start <= end:
        mid = (start + end) // 2

        if _list[mid] == item:
            return mid
        elif _list[mid] < item:
            start = mid + 1
        else:
            end = mid - 1

    return start


n = int(input())
_list = list(map(int, input().split()))
lis = [_list[0]]

for _item in _list:
    peek = lis[-1]
    if peek < _item:
        lis.append(_item)
    else:
        lis[binary_search(lis, _item)] =_item

print(len(lis))
