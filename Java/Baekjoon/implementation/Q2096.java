package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2096 (내려가기)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.04.20 (X)
 **/
public class Q2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] maxBoard = new int[3];
        int[] minBoard = new int[3];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            if(i == 0) {
                maxBoard[0] = minBoard[0] = one;
                maxBoard[1] = minBoard[1] = two;
                maxBoard[2] = minBoard[2] = three;
            } else {
                int beforeMax1 = maxBoard[0];
                int beforeMax3 = maxBoard[2];
                int beforeMin1 = minBoard[0];
                int beforeMin3 = minBoard[2];

                maxBoard[0] = one + Math.max(maxBoard[0], maxBoard[1]);
                minBoard[0] = one + Math.min(minBoard[0], minBoard[1]);

                maxBoard[2] = three + Math.max(maxBoard[1], maxBoard[2]);
                minBoard[2] = three + Math.min(minBoard[1], minBoard[2]);

                maxBoard[1] = two + Math.max(Math.max(beforeMax1, maxBoard[1]), beforeMax3);
                minBoard[1] = two + Math.min(Math.min(beforeMin1, minBoard[1]), beforeMin3);
            }
        }

        br.close();

        System.out.print(new StringBuilder().append(Math.max(Math.max(maxBoard[0], maxBoard[1]), maxBoard[2]))
                .append(' ')
                .append(Math.min(Math.min(minBoard[0], minBoard[1]), minBoard[2])));
    }
}
