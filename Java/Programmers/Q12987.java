package Programmers;

import java.util.Arrays;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12987 (숫자 게임)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.09 (X, 정렬함으로써 무시해도 되는 경계조건을 맞추려고 하다보니 못 풀음. 단순하게 생각해야 복잡한 문제를 풀 수 있다는 마음가짐을 가질 것)
 **/
public class Q12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0, bIdx = 0;
        for(int i=0;i<A.length;i++) {
            if(A[aIdx] < B[bIdx]) {
                ++answer;
                ++aIdx;
            } else if(A[aIdx] == B[bIdx]) {
                ++aIdx;
            }
            ++bIdx;
        }

        return answer;
    }
}
