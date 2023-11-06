package Programmers.brute_force;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12924 (숫자의 표현)
 * @classification: brute force
 * @문제 푼 날짜 (자력으로 풂?): 23.11.06 (O)
 * @referece: 정수론 풀이 (https://school.programmers.co.kr/learn/courses/30/lessons/12924/solution_groups?language=java)
 **/
public class Q12924 {
    public int solution(int n) {
        int answer = 0;
        int tmp = 0;

        for(int i=n;i>0;i--) {
            for(int j=i;j>0;j--) {
                tmp += j;

                if(tmp == n) {
                    ++answer;
                    break;
                } else if(tmp > n) {
                    break;
                }
            }
            tmp = 0;
        }

        return answer;
    }
}
