package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2847 (게임을 만든 동준이)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.18 (O)
 **/
public class Q2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N];

        for(int i=0;i<N;i++)
            levels[i] = Integer.parseInt(br.readLine());

        br.close();

        for(int i=N-2;i>-1;i--) {
            int high = levels[i+1];
            int low = levels[i];

            if(low < high) continue;

            result += low - (high-1);
            levels[i] = high-1;
        }

        System.out.print(result);
    }
}
