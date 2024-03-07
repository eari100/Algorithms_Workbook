package Programmers.recursion;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12985 (예상 대진표)
 * @classification: recursion
 * @문제 푼 날짜 (자력으로 풂?): 24.03.07 (O)
 **/
public class Q12985 {
    public int solution(int n, int a, int b) {
        return match(0, new int[]{a, b});
    }

    private int match(int matchCnt, int[] targetPersons) {
        int a = targetPersons[0], b = targetPersons[1];

        if( a == b ) {
            return matchCnt;
        }

        int divA = a / 2, modA = a % 2;
        int divB = b / 2, modB = b % 2;
        int a2 = divA + modA, b2 = divB + modB;

        return match(matchCnt + 1, new int[]{a2, b2});
    }
}
