# @source: https://www.acmicpc.net/problem/25314 (코딩은 체육과목 입니다)
byteSize = int(input())
dataType = ''

for _ in range(byteSize//4):
    dataType += 'long '

dataType += 'int'

print(dataType)
