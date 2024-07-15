# @source: https://www.acmicpc.net/problem/1672 (DNA 해독)
# @classification: implementation
# @문제 푼 날짜 (자력으로 풂?): 24.07.15 (O)
def get_char(lastOne, lastTwo):
    if lastOne == 'A':
        if lastTwo == 'A':
            return 'A'
        elif lastTwo == 'G':
            return 'C'
        elif lastTwo == 'C':
            return 'A'
        elif lastTwo == 'T':
            return 'G'
    elif lastOne == 'G':
        if lastTwo == 'A':
            return 'C'
        elif lastTwo == 'G':
            return 'G'
        elif lastTwo == 'C':
            return 'T'
        elif lastTwo == 'T':
            return 'A'
    elif lastOne == 'C':
        if lastTwo == 'A':
            return 'A'
        elif lastTwo == 'G':
            return 'T'
        elif lastTwo == 'C':
            return 'C'
        elif lastTwo == 'T':
            return 'G'
    elif lastOne == 'T':
        if lastTwo == 'A':
            return 'G'
        elif lastTwo == 'G':
            return 'A'
        elif lastTwo == 'C':
            return 'G'
        elif lastTwo == 'T':
            return 'T'


n = int(input())
_list = list(input())

while len(_list) > 1:
    _list.append(get_char(_list.pop(), _list.pop()))

print(_list[0])
