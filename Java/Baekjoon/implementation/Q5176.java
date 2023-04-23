package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/5176 (대회 자리)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (O)
 **/
public class Q5176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int K = Integer.parseInt(br.readLine());


        while(K-- > 0) {
            int noSeatCnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[M+1];

            while(P-- > 0) {
                int seat = Integer.parseInt(br.readLine());

                if(visited[seat]) {
                    ++noSeatCnt;
                } else {
                    visited[seat] = true;
                }
            }

            result.append(noSeatCnt).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
