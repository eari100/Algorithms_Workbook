package Programmers.dataStructure.priorityQueue;

import java.util.PriorityQueue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/138477 (명예의 전당 (1))
 * @classfication: priority queue
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (O)
 **/
public class Q138477 {
    public int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<scores.length;i++) {
            pq.offer(scores[i]);
            if(i > k - 1)
                pq.poll();

            answer[i] = pq.peek();
        }

        return answer;
    }
}
