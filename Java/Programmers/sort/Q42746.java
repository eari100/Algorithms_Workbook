package Programmers.sort;

import java.util.Arrays;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/42746 (가장 큰 수)
 *@classfication: sort
 **/
public class Q42746 {
    public String solution(int[] numbers) {
        String[] convertToStr = new String[numbers.length];

        for(int i=0;i<numbers.length;i++)
            convertToStr[i] = Integer.toString(numbers[i]);

        Arrays.sort(convertToStr, (s1, s2) -> (s1+s2).compareTo(s2+s1));

        if(convertToStr.equals("0")) return "0";

        return String.join("", convertToStr);
    }
}
