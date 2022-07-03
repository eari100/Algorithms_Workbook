package Baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1535 (안녕)
 * @classfication: dp
 * @reference: https://www.youtube.com/watch?v=frlRE7bRIDo (재귀 호출을 아름답게 함)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.03 (O, 그러나 평범한 배낭 풀고 난 뒤 날먹임)
 **/
public class Q1535 {
    static int N;
    static int[] health;
    static int[] happy;
    static final int limit = 100;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][100];
        health = new int[N];
        happy = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        System.out.print(hello(0,0));
    }

    private static int hello(int depth, int h) {
        if(depth == N) return 0;
        if(dp[depth][h] != 0) return dp[depth][h];

        int n1 = 0;
        if(h+health[depth] < limit) n1 = happy[depth] + hello(depth+1, h+health[depth]);

        int n2 = hello(depth+1, h);

        return dp[depth][h] = Math.max(n1, n2);
    }
}
