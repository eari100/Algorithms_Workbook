package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/22993 (서든어택 3)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.11.10 (O)
 **/
public class Q22993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a1 = new BigInteger(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<n;i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        br.close();

        while(!pq.isEmpty()) {
            BigInteger poll = BigInteger.valueOf(pq.poll());



            if(a1.compareTo(poll) <= 0) {
                System.out.print("No");
                return;
            }

            a1 = a1.add(poll);
        }

        System.out.print("Yes");
    }
}
