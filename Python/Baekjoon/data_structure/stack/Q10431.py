# @source: https://www.acmicpc.net/problem/3986 (좋은 단어)
# @classification: stack
# @문제 푼 날짜 (자력으로 풂?): 23.10.12 (O)

N = int(input())
good_word_cnt = 0

for _ in range(N):
    _stack = []
    _str = input()
    for c in _str:
        if not _stack:
            _stack.append(c)
        else:
            peek = _stack[-1]
            if peek == c:
                del _stack[-1]
            else:
                _stack.append(c)

    if not _stack:
        good_word_cnt += 1

print(good_word_cnt)
