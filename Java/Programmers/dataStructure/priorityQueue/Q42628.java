package Programmers.dataStructure.priorityQueue;

import java.util.PriorityQueue;


/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/42628# (이중우선순위큐)
 * @classification: priority queue
 * @문제 푼 날짜 (자력으로 풂?): 24.08.25 (X)
 **/
public class Q42628 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        int size = 0;

        for (String operation : operations) {
            String[] data = operation.split(" ");
            String order = data[0];
            int num = Integer.parseInt(data[1]);

            if(order.equals("I")) {
                minQ.add(num);
                maxQ.add(num);
                ++size;
            } else {
                if(num == 1) {
                    if( !maxQ.isEmpty() ) {
                        int mx = maxQ.poll();
                        minQ.remove(mx);
                    }
                } else {
                    if( !minQ.isEmpty() ) {
                        int mn = minQ.poll();
                        maxQ.remove(mn);
                    }
                }

                if(size > 0)
                    --size;
            }
        }

        if(size < 1) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQ.poll(), minQ.poll()};
        }
    }
}
