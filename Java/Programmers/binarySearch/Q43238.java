package Programmers.binarySearch;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/43238 (입국심사)
 * @classfication: binary search
 * @문제 푼 날짜 (자력으로 풂?): 23.08.27 (X, 특이사항 - 데이터 범위에 오류가 있는 문제)
 **/
public class Q43238 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long max = 0;
        for(int time : times)
            max = Math.max(max, time);

        long str = 1;
        long end = max * n; // 테스트 케이스에만 적용되는 최댓값

        while(str <= end) {
            long mid = (str + end) / 2;

            long count = 0;

            for(int time : times) {
                count += mid / time;
            }

            if(count < n) {
                str = mid + 1;
            } else if(count >= n) {
                answer = mid;
                end = mid - 1;
            }
        }

        return answer;
    }
}
