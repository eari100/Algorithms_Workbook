package Baekjoon.dataStructure.priorityQueue;

import java.io.*;
import java.util.PriorityQueue;

/**
 * @source: https://www.acmicpc.net/problem/1927 (최소 힙)
 * @classfication: priority queue
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.04 (O)
 **/
public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        while(--T > -1) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if( queue.isEmpty() ) sb.append('0').append('\n');
                else sb.append(queue.poll()).append('\n');
            } else {
                queue.offer(input);
            }
        }
        br.close();

        System.out.print(sb);
    }
}
