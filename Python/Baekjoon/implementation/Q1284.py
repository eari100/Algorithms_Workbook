result = ''

while True:
    _len = 1
    n = input()

    if n == '0':
        break

    for x in n:
        if x == '1':
            _len += 3
        elif x == '0':
            _len += 5
        else :
            _len += 4

    result += str(_len) + '\n'

print(result)