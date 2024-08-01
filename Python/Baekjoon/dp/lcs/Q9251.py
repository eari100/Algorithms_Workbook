# @source: https://www.acmicpc.net/problem/9251 (LCS)
# @classification: lsc
# @문제 푼 날짜 (자력솔): 24.08.01 (X)
_str1 = input()
_str2 = input()
dp = [[0] * ( len(_str2) + 1 ) for _ in range(len(_str1) + 1)]

for i in range(len(_str1)):
    index1 = i + 1
    for j in range(len(_str2)):
        index2 = j + 1

        if _str1[i] == _str2[j]:
            dp[index1][index2] = dp[index1 - 1][index2 - 1] + 1
        else:
            dp[index1][index2] = max(dp[index1 - 1][index2], dp[index1][index2 - 1])

print(dp[len(_str1)][len(_str2)])