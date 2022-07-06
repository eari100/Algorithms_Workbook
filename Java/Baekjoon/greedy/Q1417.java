package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *@source: https://www.acmicpc.net/problem/1417 (국회의원 선거)
 *@classfication: greedy, priority queue
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.06 (O)
 **/
public class Q1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=1;i<N;i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        br.close();

        int result = 0;

        if(N > 1) {
            while(true) {
                int max = pq.poll();
                if(max < dasom) break;

                ++dasom;
                pq.offer(max-1);
                ++result;
            }
        }

        System.out.print(result);
    }
}
