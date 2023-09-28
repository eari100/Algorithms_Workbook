T = int(input())

match = 9

for _ in range(T):
    sumY, sumK = 0, 0

    for _ in range(match):
        Y, K = map(int, input().split())
        sumY += Y
        sumK += K

    if sumY == sumK:
        print('Draw')
    elif sumY > sumK:
        print('Yonsei')
    elif sumY < sumK:
        print('Korea')