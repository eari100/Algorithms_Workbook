package Baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/15903
 * @classfication: greedy, priority queue
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.20 (O)
 **/
public class Q15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

       PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            pq.offer(Long.parseLong(st.nextToken()));

        for(int i=0;i<m;i++) {
            long sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }

        long totalSum = 0;

        while( !pq.isEmpty() ) {
            totalSum += pq.poll();
        }

        br.close();

        System.out.print(totalSum);
    }
}
