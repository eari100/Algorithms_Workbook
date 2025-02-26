package Baekjoon.dp.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/9252 (LCS 2)
 * @classification: LCS
 * @문제 푼 날짜 (혼자 힘으로 풂?): 25.02.27 (X)
 **/
public class Q9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()][str2.length()];

        for(int i=0;i<str1.length();i++) {
            char a = str1.charAt(i);

            for(int j=0;j<str2.length();j++) {
                char b = str2.charAt(j);

                if(a == b) {
                    if(i > 0 && j > 0) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    int x = 0, y = 0;

                    if(i > 0) {
                        x = dp[i-1][j];
                    }

                    if(j > 0) {
                        y = dp[i][j-1];
                    }

                    dp[i][j] = Math.max(x, y);
                }
            }
        }

        br.close();

        StringBuilder result = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;

        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                result.append(str1.charAt(i));
                i--;
                j--;
            } else if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.print(result.length() + "\n" +result.reverse());
    }
}
