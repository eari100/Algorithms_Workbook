package Programmers.binarySearch;

import java.util.Arrays;

/**
 * @source: https://school.programmers.co.kr/app/tests/45366/challenges/algorithms/10082?language=java (예산)
 * @classfication: binarySearch
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.07 (X)
 **/
public class Cml_1_3 {
    public int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets);

        int str = 0;
        int end = budgets[budgets.length-1];

        while(str <= end) {
            int mid = (str + end)/2;
            int sum = 0;

            for(int x : budgets) {
                if(x >= mid) sum += mid;
                else sum += x;
            }

            if(sum > M) {
                end = mid-1;
            } else {
                str = mid+1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;
    }
}
