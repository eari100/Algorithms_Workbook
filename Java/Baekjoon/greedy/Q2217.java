package Baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2217 (로프)
 * @classfication: Greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.26 (O)
 **/
public class Q2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(arr);

        int cnt = n;
        int maxWeight = 0;

        for(int i=0;i<n;i++) {
            maxWeight = Math.max(maxWeight, arr[i] * cnt);
            --cnt;
        }

        System.out.print(maxWeight);
    }
}
