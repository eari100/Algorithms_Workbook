package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/20044 (Project Teams)
 * @classfication: greedy, math
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.24 (O, 카테고리 힌트 없이 풀 수 있었을까 의문이 듦)
 **/
public class Q20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        n *= 2;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(--n >= 0) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        int minTeam = 200000;
        for(int i=0;i<arr.length/2;i++) {
            minTeam = Math.min(minTeam, arr[i] + arr[arr.length-(i+1)]);
        }

        System.out.print(minTeam);
    }
}
