package Programmers.binarySearch;

import java.util.Arrays;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/86051 (없는 숫자 더하기)
 *@classfication: binary search
 **/
public class Q86051 {
    public int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        for(int i=0;i<=9;i++)
            if( !binarySearch(numbers, i) ) answer += i;

        return answer;
    }

    private boolean binarySearch(int[] numbers, int x) {

        int strIdx = 0;
        int endIdx = numbers.length-1;
        int mid;

        while(strIdx <= endIdx) {
            mid = (strIdx+endIdx)/2;
            if(x == numbers[mid]) return true;
            else if(x < numbers[mid]) endIdx = mid-1;
            else if(x >  numbers[mid]) strIdx = mid+1;
        }

        return false;
    }
}
