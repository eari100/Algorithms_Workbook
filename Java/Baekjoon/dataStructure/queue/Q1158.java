package Baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1158 (요세푸스 문제)
 * @classfication: Queue
 * @문제 푼 날짜 (자력으로 풂?): 23.04.30 (O)
 **/
public class Q1158 {
    public static void main(String[] args) throws IOException {
        StringBuilder 요세푸스_순열 = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<N+1;i++) {
            queue.offer(i);
        }

        요세푸스_순열.append('<');

        while( !queue.isEmpty() ) {
            for(int i=0;i<K;i++) {
                int poll = queue.poll();

                if(i == K-1) {
                    요세푸스_순열.append(poll).append(", ");
                } else {
                    queue.offer(poll);
                }
            }
        }

        요세푸스_순열.delete(요세푸스_순열.length()-2, 요세푸스_순열.length())
                .append('>');

        System.out.print(요세푸스_순열);
    }
}
