package Baekjoon;

import java.io.*;

public class Q2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] stairs = new int[n+1];

        for(int i=1;i<=n;i++)
            stairs[i] = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++) {
            if(i==1) dp[i] = stairs[i];
            else if(i==2) dp[i] = dp[i-1] + stairs[i];
            else dp[i] = Math.max(stairs[i-1] + dp[i-3], dp[i-2]) + stairs[i];
        }
        br.close();

        System.out.print(dp[n]);
    }
}
