package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/26215 (눈 치우기)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 25.03.01 (O)
 **/
public class Q26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;

        while(!pq.isEmpty()) {
            if(++time == 1441) {
                System.out.print(-1);
                return;
            }

            int poll1 = pq.poll();

            if( !pq.isEmpty() ) {
                int poll2 = pq.poll();

                if(--poll2 > 0)
                    pq.offer(poll2);
            }

            if(--poll1 > 0)
                pq.offer(poll1);
        }

        br.close();

        System.out.print(time);
    }
}
