# @source: https://www.acmicpc.net/problem/15312 (이름 궁합)
# @classification: string, implementation
# @문제 푼 날짜 (자력으로 풂?): 23.10.05 (O)
# todo: temp_answer 없어도 가능
A, B = input(), input()
score = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]
answer = []

for i in range(len(A)):
    answer.append(score[ord(A[i]) - ord('A')])
    answer.append(score[ord(B[i]) - ord('A')])

str_len = len(answer)
while len(answer) > 2:
    answer_temp = []

    for i in range(1, len(answer)):
        answer_temp.append((answer[i - 1] + answer[i]) % 10)

    answer = answer_temp

print(answer[0], answer[1], sep='')
