package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/12865 (평범한 배낭)
 * @classfication: dp
 * @reference: https://www.youtube.com/watch?v=frlRE7bRIDo (재귀 호출을 아름답게 함)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.02 (X)
 **/
public class Q12865 {
    static int[][] dp;
    static int N;
    static int K;
    static int[] w;
    static int[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        w = new int[N];
        v = new int[N];
        dp = new int[N][K+1];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        System.out.println(findAnswer(0, 0));
    }

    private static int findAnswer(int depth, int weight) {
        if(depth == N) return 0;
        if(dp[depth][weight] != 0) return dp[depth][weight];

        int n1 = 0;

        if(weight + w[depth] <= K)
            n1 = v[depth] +  findAnswer(depth+1, weight + w[depth]);

        int n2 = findAnswer(depth+1, weight);

        return dp[depth][weight] = Math.max(n1, n2);
    }
}
