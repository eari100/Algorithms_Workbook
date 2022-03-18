package Baekjoon;

import java.io.*;

/**
 *@source: https://www.acmicpc.net/problem/11726 (2×n 타일링)
 *@classfication: dp
 *@reference: https://kosaf04pyh.tistory.com/222
 **/
public class Q11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] memo = new int[1001];
        memo[1] = 1;
        memo[2] = 2;

        for(int i=3;i<=n;i++)
            memo[i] = (memo[i-1] + memo[i-2])%10007;

        System.out.print(memo[n]);
    }
}
