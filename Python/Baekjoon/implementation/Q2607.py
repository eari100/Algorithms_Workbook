# @source: https://www.acmicpc.net/problem/2607 (비슷한 단어)
# @classification: implementation
# @문제 푼 날짜 (혼자 힘으로 풂?): 24.06.29 (O)
match_cnt = 0
len1 = 0
alpha = [0] * 26

for i in range(int(input())):
    _str = input()

    if i == 0:
        len1 = len(_str)
        for c in _str:
            alpha[ord(c) - ord('A')] += 1
    else:
        copyAlpha = alpha[:]
        len2 = len(_str)

        if len1 - 1 <= len2 <= len1 + 1:
            count = min(len1, len2)

            if len1 == len2:
                count -= 1

            for c in _str:
                index = ord(c) - ord('A')
                if copyAlpha[index] > 0:
                    count -= 1
                    copyAlpha[index] -= 1

            if count <= 0:
                match_cnt += 1

print(match_cnt)
