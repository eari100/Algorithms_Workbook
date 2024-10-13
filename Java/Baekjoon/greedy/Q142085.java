package Baekjoon.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/142085 (디펜스 게임)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 24.10.13 (X, 교육적인 문제 업솔빙 하자)
 **/
public class Q142085 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int e : enemy) {
            n -= e;
            pq.add(e);

            if(n < 0) {
                if( k > 0 && !pq.isEmpty() ) {
                    n += pq.poll();
                    --k;
                } else {
                    break;
                }
            }

            ++answer;
        }

        return answer;
    }
}
