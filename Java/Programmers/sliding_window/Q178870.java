package Programmers.sliding_window;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/178870 (연속된 부분 수열의 합)
 * @classification: sliding window
 * @문제 푼 날짜 (자력으로 풂?): 24.09.01 (O)
 **/
public class Q178870 {
    public int[] solution(int[] sequence, int k) {
        int str = 0, end = 0, minLen = sequence.length + 1;
        int sum = sequence[0];
        int[] answer = new int[2];

        while(str <= end && end < sequence.length) {
            if(sum == k) {
                int len = end - str + 1;

                if(len < minLen) {
                    minLen = len;
                    answer[0] = str;
                    answer[1] = end;
                }

                sum -= sequence[str];
                ++str;
            } else if(sum < k) {
                ++end;

                if(end < sequence.length)
                    sum += sequence[end];
            } else if(sum > k) {
                sum -= sequence[str];
                ++str;
            }
        }

        return answer;
    }
}
