# @source: https://www.acmicpc.net/problem/1703 (생장점)
# @classification: implementation
# @문제 푼 날짜 (자력솔): 24.09.22 (O)
answer = []

while True:
    _str = input()

    if _str == '0': break

    _arr = list(map(int, _str.split(' ')))
    _len = _arr[0] * 2
    ta = 1

    for i in range(1, _len, 2):
        sf, rem = _arr[i], _arr[i+1]
        ta = ta * sf - rem

    answer.append(ta)

print('\n'.join(map(str, answer)))