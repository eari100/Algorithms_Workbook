package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/24511 (queuestack)
 * @classification: deque
 * @문제 푼 날짜 (자력으로 풂?): 25.02.11 (O)
 **/
public class Q24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] isDeque = new boolean[n];
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++) {
            if(Integer.parseInt(st.nextToken()) == 0) {
                isDeque[i] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());

            if(isDeque[i])
                deque.addLast(num);
        }

        int c = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<c;i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.addFirst(num);
            result.append(deque.pollLast()).append(' ');
        }

        br.close();

        System.out.print(result);
    }
}
