package Programmers.implementation;

import java.util.Arrays;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12939 (최댓값과 최솟값)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (O)
 **/
public class Q12939 {
    public String solution(String s) {
        int[] sArr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(sArr);

        StringBuilder answer = new StringBuilder();
        answer.append(sArr[0]).append(' ').append(sArr[sArr.length-1]);
        return answer.toString();
    }
}
