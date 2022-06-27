package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1138 (한 줄로 서기)
 * @classfication: implementation, greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * @reference: https://lovelyunsh.tistory.com/118
 * 1. 22.06.27 (O)
 **/
public class Q1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=1;i<=N;i++) {
            int leftCnt = Integer.parseInt(st.nextToken());

            for(int j=0;j<=leftCnt;j++) {
                if(line[j] != 0) leftCnt++;
            }

            line[leftCnt] = i;
        }

        Arrays.stream(line).forEach(l -> System.out.print(l+" "));
    }
}
