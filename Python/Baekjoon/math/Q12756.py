attack1, defense1 = map(int, input().split())
attack2, defense2 = map(int, input().split())

a = (defense1 // attack2) + (0 if defense1 % attack2 == 0 else 1)
b = (defense2 // attack1) + (0 if defense2 % attack1 == 0 else 1)

if a == b:
    print('DRAW')
elif a > b:
    print('PLAYER A')
else:
    print('PLAYER B')
