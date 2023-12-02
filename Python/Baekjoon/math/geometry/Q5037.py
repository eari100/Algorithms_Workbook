# @source: https://www.acmicpc.net/problem/5073 (삼각형과 세 변)
# @classification: geometry
# @문제 푼 날짜 (자력으로 풂?): 23.12.02 (X, 삼각 부등식 공식 참고)
Equilateral = 'Equilateral'
Isosceles = 'Isosceles'
Scalene = 'Scalene'
Invalid = 'Invalid'


def triangle_inequality(l1, l2, l3):
    return False if l1 >= l2 + l3 or l2 >= l1 + l3 or l3 >= l1 + l2 else True


while True:
    l1, l2, l3 = map(int, input().split())

    if l1 == 0 and l2 == 0 and l3 == 0:
        break

    if triangle_inequality(l1, l2, l3) == False:
        print(Invalid)
    elif l1 == l2 == l3:
        print(Equilateral)
    elif l1 == l2 or l1 == l3 or l2 == l3:
        print(Isosceles)
    else:
        print(Scalene)
