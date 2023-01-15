package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11501 (주식)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.15 (O)
 **/
public class Q11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr;
        StringTokenizer st;
        int N = 0;
        StringBuilder result = new StringBuilder();

        for(int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());

            long benefit = 0;

            for(int j=0;j<N;j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int max = arr[N-1];

            for(int j=N-2;j>=0;j--) {
                if(max < arr[j]) {
                    max = arr[j];
                } else {
                    benefit += max - arr[j];
                }
            }

            result.append(benefit).append('\n');
        }
        System.out.print(result);
        br.close();
    }
}
