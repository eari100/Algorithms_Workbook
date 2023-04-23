package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2460 (지능형 기차 2)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (O)
 **/
public class Q2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stationCnt = 10;
        int humanCnt = 0;
        int maxHumanCnt = 0;
        StringTokenizer st;

        while(stationCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int minus = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());

            humanCnt += plus;
            humanCnt -= minus;

            maxHumanCnt = Math.max(maxHumanCnt, humanCnt);
        }

        br.close();

        System.out.print(maxHumanCnt);
    }
}
