package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/12852 (1로 만들기 2)
 *@classfication: dp
 **/
public class Q12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] calCnt = new int[N + 1];
        String[] makeProcess = new String[N + 1];

        calCnt[1] = 0;
        makeProcess[1] = "1";

        for (int i = 2; i <= N; i++) {
            int post = 0;
            int cnt = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                post = i / 3;
                cnt = calCnt[post];
            }
            if (i % 2 == 0) {
                if(cnt > calCnt[i/2]) { // calCnt[i % 3], calCnt[i % 2] 중 최적의 해 탐색
                    post = i / 2;
                    cnt = calCnt[post];
                }
            }

            if(cnt > calCnt[i-1]) post = i-1;

            calCnt[i] = calCnt[post] + 1;
            makeProcess[i] = i + " " + makeProcess[post];
        }

        System.out.println(calCnt[N]);
        System.out.println(makeProcess[N]);
    }
}
