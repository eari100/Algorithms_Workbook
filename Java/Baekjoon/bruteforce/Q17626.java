package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/17626 (Four Squares)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 24.01.28 (X, 힌트 열람)
 **/
// todo: 점화식 존재
public class Q17626 {
    static int num = 0;
    static int min = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        br.close();
        dfs(0, new int[]{0, 0, 0, 0}, 0);
        System.out.print(min);
    }

    private static void dfs(int prevOrder, int[] arr, int sum) {
        if(num == sum) {
            min = Math.min(prevOrder+1, min);
            return;
        }

        if(num < sum)
            return;

        for(int i=prevOrder;i<4;i++) {
            if(i > 0 && arr[i-1] == arr[i]) {
                continue;
            }

            int currSum = sum + arr[i] + arr[i] + 1;

            ++arr[i];
            dfs(i, arr, currSum);
            --arr[i];
        }
    }
}
