package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1049 (기타줄)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.22 (O)
 **/
public class Q1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int setCost = Integer.MAX_VALUE;
        int oneCost = Integer.MAX_VALUE;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int nSet = Integer.parseInt(st.nextToken());
            int nOne = Integer.parseInt(st.nextToken());

            setCost = Math.min(setCost, nSet);
            oneCost = Math.min(oneCost, nOne);
        }
        br.close();

        int allCost = 0;

        while(N > 0) {
            if(N <= 6) {
                allCost += Math.min(setCost, oneCost*N);
                break;
            }

            if(setCost > oneCost * 6) setCost = oneCost * 6;

            allCost += setCost * (N/6);
            N %= 6;
        }

        System.out.print(allCost);
    }
}
