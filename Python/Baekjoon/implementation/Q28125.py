# @source: https://www.acmicpc.net/problem/28125 (2023 아주머학교 프로그래딩 정시머힌)
# @classification: implementation
# @문제 푼 날짜 (자력솔): 24.07.30 (X)
char_list = ['@', '[', '!', ';', '^', '0', '7']
char_list2 = ['a', 'c', 'i', 'j', 'n', 'o', 't']

for _ in range(int(input())):
    _str = input()
    diff = 0
    chr_len = 0
    cov_str = ''

    i = 0
    while i < len(_str):
        if _str[i:min(i+3, len(_str))] == "\\\\'":
            cov_str += 'w'
            i += 3
            chr_len += 1
            diff += 1
        elif _str[i:min(i+2, len(_str))] == "\\'":
            cov_str += 'v'
            i += 2
            chr_len += 1
            diff += 1
        else:
            is_match = False
            _chr = _str[i]
            i += 1
            chr_len += 1

            for j in range(len(char_list)):
                _chr2 = char_list[j]
                if _chr == _chr2:
                    is_match = True
                    diff += 1
                    break

            if is_match:
                cov_str += char_list2[j]
            else:
                cov_str += _chr

    if chr_len / 2 <= diff :
        print("I don't understand")
    else:
        print(cov_str)
