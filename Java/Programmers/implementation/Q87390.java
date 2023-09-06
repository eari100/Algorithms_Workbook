package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/87390 (n^2 배열 자르기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.06 (O)
 **/
// todo: 더 단순한 로직으로 바꿀 것
public class Q87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int index = 0;

        int div =  (int) (left / n);
        int rem =  (int) (left % n);

        int iIdx = div + 1 + (rem == n ? -1 : 0);
        int jIdx = rem + 1;

        L1: for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i == 1 && j == 1) {
                    i = iIdx;
                    j = jIdx;
                }

                int x = j;

                if(j < i)
                    x = i;

                if(index == right-left+1)
                    break L1;

                answer[index++] = x;
            }
        }

        return answer;
    }
}
