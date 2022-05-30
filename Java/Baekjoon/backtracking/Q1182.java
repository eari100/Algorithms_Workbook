package Baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1182 (부분수열의 합)
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.30 (O)
 **/
public class Q1182 {
    static int[] arr;
    static int answer;
    static int N;
    static int S;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dfs(0);
        System.out.print(answer);
    }

    private static void dfs(int idx) {
        if(idx!=0 && S == sum) ++answer;

        for(int i=idx;i<N;i++) {
            sum += arr[i];
            dfs(i+1);
            sum -= arr[i];
        }
    }
}
