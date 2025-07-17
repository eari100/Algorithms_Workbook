package Programmers.simulation;

import java.util.*;

/**
 * @source: https://school.programmers.co.kr/learn/courses/20848/lessons/255906# ([PCCP 모의고사 #2] 3번 - 카페 확장)
 * @classification: simulation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 25.07.18 (X, 제미나이 디버깅)
 **/
public class Q255906 {
    public static int solution(int[] menu, int[] order, int k) {
        int _max = 0;
        int order_index = 0;
        int time = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>(); // 추가 시간

        while(order_index < order.length) {
            if(q.isEmpty()) {
                time = Math.max(order_index * k, time);
                int work_time = menu[order[order_index++]];
                q.addLast(work_time);
            }

            time += q.peek();

            while(order_index < order.length) {
                if(time <= k * order_index) break;

                q.addLast(menu[order[order_index++]]);
            }

            _max = Math.max(_max, q.size());

            q.poll();
        }

        return _max;
    }
}
