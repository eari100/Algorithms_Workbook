package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/1449 (수리공 항승)
 *@classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.06 (O)
 **/
public class Q1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] holes = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            holes[i] = Integer.parseInt(st.nextToken());

        br.close();

        Arrays.sort(holes);

        int tapeCnt = 0;
        double maxTape = 0;

        for(int hole : holes) {
            if(hole + 0.5 > maxTape) {
                maxTape = hole + L;
                ++tapeCnt;
            }
        }

        System.out.print(tapeCnt);
    }
}
