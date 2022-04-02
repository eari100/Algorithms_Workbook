package Baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/1149
 *@classfication: dp
 *@reference: https://st-lab.tistory.com/128
 **/
public class Q1149 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // dp[n][0] = min(dp[n-1][1], dp[n-1][2])
        int x = 0, y = 0;
        for(int i=1;i<arr.length;i++) {
            for(int j=0;j<3;j++) {
                if(j==0) {
                    x = 1;
                    y = 2;
                } else if(j==1) {
                    x = 0;
                    y = 2;
                } else if(j==2) {
                    x = 0;
                    y = 1;
                }
                arr[i][j] += Math.min(arr[i-1][x], arr[i-1][y]);
            }
        }
        System.out.print(Math.min(arr[arr.length-1][0], Math.min(arr[arr.length-1][1], arr[arr.length-1][2])));
    }
}
