package Baekjoon.dataStructure.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @source: https://www.acmicpc.net/problem/11279 (최대 힙)
 * @classfication: priority queue
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.07 (O)
 **/
public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // Max-Heap
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(--N > -1) {
            int cmd = Integer.parseInt(br.readLine());

            if(cmd == 0) {
                if(queue.size() == 0) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            } else {
                queue.offer(cmd);
            }
        }
        br.close();

        System.out.print(sb);
    }
}
