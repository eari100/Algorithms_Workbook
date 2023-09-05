package Programmers.string;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12951 (JadenCase 문자열 만들기)
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?): 23.09.06(O)
 **/
public class Q12951 {
    final static char BLANK = ' ';

    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        result.append(Character.toUpperCase(s.charAt(0)));

        for(int i=1;i<s.length();i++) {
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);

            if(prev == BLANK) {
                result.append(Character.toUpperCase(curr));
            } else {
                result.append(Character.toLowerCase(curr));
            }
        }

        return result.toString();
    }
}
