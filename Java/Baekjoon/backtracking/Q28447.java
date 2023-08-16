package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/28447 (마라탕 재료 고르기)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.08.12 (O)
 **/
public class Q28447 {
    static int maxResult = -Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        dfs(0, new int[K]);

        System.out.println(maxResult);
    }

    private static void dfs(int depth, int[] temp) {
        if(depth == temp.length) {
            int result = 0;

            for(int i=0;i<temp.length;i++) {
                for(int j=i+1;j<temp.length;j++) {
                    result += arr[temp[i]][temp[j]];
                }
            }

            maxResult = Math.max(maxResult, result);

            return;
        }

        int str = 0;

        if(depth > 0) {
            str = temp[depth-1] + 1;
        }

        for(int i=str;i<arr.length;i++) {
            temp[depth] = i;
            dfs(depth+1, temp);
        }
    }
}
