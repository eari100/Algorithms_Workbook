package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/18111 (마인크래프트)
 * @classfication: brute force
 * @문제 푼 날짜 (자력으로 풂?): 23.10.04 (X)
 **/
// todo: dp로 성능 향상 가능
public class Q18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = 256, max = 0;
        int[][] board = new int[N][M];
        StringBuilder result = new StringBuilder();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int h = Integer.parseInt(st.nextToken());
                board[i][j] = h;

                min = Math.min(min, h);
                max = Math.max(max, h);
            }
        }

        int correctTime = Integer.MAX_VALUE, correctHeight = 0;

        for(int h=min;h<=max;h++) {
            int copyB = B;
            int time = 0;

            for(int[] arr : board) {
                for(int i : arr) {
                    if(i < h) {
                        time += (h - i);
                        copyB -= (h - i);
                    } else if(i > h) {
                        time += 2 * (i - h);
                        copyB += (i - h);
                    }
                }
            }

            if(copyB < 0) continue;

            if(time <= correctTime) {
                correctTime = time;
                correctHeight = h;
            }
        }

        result.append(correctTime).append(' ').append(correctHeight);
        System.out.print(result);
        br.close();
    }
}
