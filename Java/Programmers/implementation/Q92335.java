package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/92335 (2022 KAKAO BLIND RECRUITMENT > k진수에서 소수 개수 구하기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.08.19 (X)
 **/
public class Q92335 {
    public int solution(int n, int k) {
        int answer = 0;
        String x = Integer.toString(n, k);
        String[] arr = x.split("0");

        for(String item : arr) {
            if(item.equals("")) continue;

            long num = Long.parseLong(item);

            if(num == 1) continue;

            boolean isPrime = true;

            for(long i=2;i<=Math.sqrt(num);i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) ++answer;
        }

        return answer;
    }
}
