package leetcode.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/9084 (9084. 동전)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.06 (X)
 **/
public class Q9084 {
    static int[] dp;
    static int[] coins;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(--T > -1) {
            int N = Integer.parseInt(br.readLine());
            coins = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
                coins[i] = Integer.parseInt(st.nextToken());

            target = Integer.parseInt(br.readLine());
            dp = new int[target+1];
            dp[0] = 1;

            sb.append(getAnswer()).append('\n');
        }
        br.close();

        System.out.print(sb);
    }

    private static int getAnswer() {
        for(int coin : coins) {
            for(int i=coin;i<=target;i++) {
                dp[i] += dp[i-coin];
            }
        }

        return dp[target];
    }
}
