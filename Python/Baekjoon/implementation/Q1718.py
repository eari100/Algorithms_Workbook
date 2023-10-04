# @source: https://www.acmicpc.net/problem/1718 (암호)
# @classfication: implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.05 (X)
plane, key = input(), input()
crypto = ''

for i in range(len(plane)):
    if plane[i] == ' ':
        crypto += ' '
    else:
        diff = ord(plane[i]) - ord(key[i % len(key)]) - 1
        crypto += chr(diff % 26 + ord('a'))

print(crypto)
