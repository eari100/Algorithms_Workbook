package Programmers.sort;

import java.util.Arrays;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12941 (최솟값 만들기)
 * @classfication: sort
 * @문제 푼 날짜 (자력으로 풂?): 23.09.06(O)
 **/
public class Q12941 {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++) {
            int x = A[i] * B[B.length - 1 - i];
            answer += x;
        }

        return answer;
    }
}
