package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2293 (동전 1)
 * @classfication: dp
 * @reference
 * 이론: https://velog.io/@jxlhe46/%EB%B0%B1%EC%A4%80-2293%EB%B2%88.-%EB%8F%99%EC%A0%84-1-bfi120m5
 * 더 좋은 풀이: https://www.acmicpc.net/source/23199462
 * @문제 푼 날짜 (자력으로 풂?): 23.08.13 (X)
 **/
public class Q2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for(int i=0;i<n;i++)
            coins[i] = Integer.parseInt(br.readLine());

        br.close();

        int[][] dp = new int[n][k+1];

        for(int i=0;i<coins.length;i++) {
            int coin = coins[i];

            for(int cnt=1;cnt<=k;cnt++) {
                int prevCoinVal = 0;
                int currCoinVal = 0;

                if(cnt == coin)
                    ++dp[i][cnt];

                if(i > 0)
                    prevCoinVal = dp[i-1][cnt];
                if(cnt > coin)
                    currCoinVal = dp[i][cnt - coin];

                dp[i][cnt] += prevCoinVal + currCoinVal;
            }
        }

        System.out.print(dp[n-1][k]);
    }
}
