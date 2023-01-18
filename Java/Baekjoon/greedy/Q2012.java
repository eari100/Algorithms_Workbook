package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2012 (등수 매기기)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.18 (X)
 **/
public class Q2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N+1];
        long angryScoreSum = 0;

        for(int i=1;i<N+1;i++)
            scores[i] += Integer.parseInt(br.readLine());

        br.close();

        Arrays.sort(scores);

        for(int i=1;i<N+1;i++)
            angryScoreSum += Math.abs(scores[i] - i);

        System.out.print(angryScoreSum);
    }
}
