package Baekjoon.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/29792 (규칙적인 보스돌이)
 * @classfication: knapsack
 * @문제 푼 날짜 (자력으로 풂?): 23.09.08 (X, 냅색이라는 점을 알았으나 구현하지 못해서 냅색 코드 참고해서 풂)
 **/
public class Q29792 {
    static int[][] dp;
    static long[] boss;
    static int[] mesoArr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] characters = new long[N];

        for(int i=0;i<N;i++) {
            characters[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(characters);

        int meso = 0;
        boss = new long[K];
        mesoArr = new int[K];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            boss[i] = Long.parseLong(st.nextToken());
            mesoArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=characters.length - 1;i>characters.length - 1 - M;i--) {
            dp = new int[K][(15*60)+1];
            meso += sol(0, 0, characters[i]);
        }

        System.out.print(meso);
    }

    private static int sol(int depth, int time, long attack) {
        if(depth == K) return 0;
        if(dp[depth][time] != 0)
            return dp[depth][time];

        int n1 = 0;
        long t1 = boss[depth] / attack;

        if(t1 <= 15 * 60) {
            if(boss[depth] % attack > 0)
                ++t1;

            if(time + t1 <= 15 * 60 )
                n1 = mesoArr[depth] + sol(depth + 1, time + (int)t1, attack);
        }

        int n2 = sol(depth + 1, time, attack);

        return dp[depth][time] = Math.max(n1, n2);
    }
}
