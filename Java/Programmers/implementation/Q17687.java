package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/17687 (N진수 게임)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.18 (O)
 **/
// todo: 업솔빙
public class Q17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder dataList = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int i = 0;

        while(dataList.toString().length() < m * t) {
            String data = Integer.toString(i++, n);
            dataList.append(data.toUpperCase());
        }

        int j = p - 1;
        while(t-- > 0) {
            answer.append(dataList.toString().charAt(j));
            j+=m;
        }

        return answer.toString();
    }
}
