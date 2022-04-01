package Programmers;

import java.util.PriorityQueue;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/42626 (더맵게)
 *@classfication: heap
 **/
public class Q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap =  new PriorityQueue<>();

        for(int s : scoville)
            heap.offer(s);

        while(heap.peek() < K) {
            if(heap.size() == 1) return -1;

            ++answer;

            int fir = heap.poll();
            int sec = heap.poll();

            int mix = fir + (sec * 2);
            heap.offer(mix);
        }

        return answer;
    }
}
