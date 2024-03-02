package Programmers.dp;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12980 (점프와 순간 이동)
 * @classification: dp (top down)
 * @문제 푼 날짜 (자력으로 풂?): 24.03.03 (X)
 **/
public class Q12980 {
    public int solution(int n) {
        int answer = 1;

        while(n > 1) {
            if(n % 2 == 1) ++answer;
            n /= 2;
        }

        return answer;
    }
}
