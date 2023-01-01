package Baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/11659 (구간 합 구하기 4)
 *@classfication: prefix sum
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.01 (O)
 **/
public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<N+1;i++)
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            result.append(prefixSum[end] - prefixSum[str-1]).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
