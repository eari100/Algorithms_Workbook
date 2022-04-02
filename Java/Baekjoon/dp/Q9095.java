package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/9095
 *@classfication: dp
 **/
public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] tArr = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            tArr[i] = input;
            if(max<input)
                max = input;
        }
        br.close();

        int[] memo = new int[max + 1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i <= max; i++)
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];

        for (int i : tArr)
            sb.append(memo[i]).append("\n");

        System.out.print(sb);
    }
}
