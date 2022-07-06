package Programmers.sort;

import java.util.Arrays;

/**
 * @source: https://programmers.co.kr/learn/courses/30/lessons/42746 (가장 큰 수)
 * @classfication: sort
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 기록이 안됨 (X)
 * 2. 22.07.06 (X)
 **/
public class Q42746 {
    public String solution(int[] numbers) {
        String[] convertToStr = new String[numbers.length];

        for(int i=0;i<numbers.length;i++)
            convertToStr[i] = Integer.toString(numbers[i]);

        Arrays.sort(convertToStr, (s1, s2) -> s2.concat(s1).compareTo(s1.concat(s2)));

        if(convertToStr.equals("0")) return "0";

        return String.join("", convertToStr);
    }
}
