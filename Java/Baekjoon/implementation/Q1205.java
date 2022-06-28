package Baekjoon.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1205 (등수 구하기)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.29 (O)
 **/
public class Q1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] ranking = new int[P];
        Arrays.fill(ranking, -1);

        if(N > 0) st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            ranking[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        System.out.print(getRank(ranking, score, P));
    }

    private static int getRank(int[] ranking, int score, int lastRank) {
        if(ranking[lastRank-1] >= score) {
            return  -1;
        }

        for(int i=lastRank;i>0;i--) {
            if(score < ranking[i-1]) {
                return i+1;
            }
        }

        return 1;
    }
}
