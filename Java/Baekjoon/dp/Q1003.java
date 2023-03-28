package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1003 (피보나치 함수)
 * @classfication: dp
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.03.28 (O)
 **/
public class Q1003 {
    static int[] zeroCntArr = new int[41];
    static int[] oneCntArr = new int[41];

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();

        zeroCntArr[0] = 1;
        zeroCntArr[1] = 0;

        oneCntArr[0] = 0;
        oneCntArr[1] = 1;

        for(int i=2;i<40+1;i++)
            fibonacci(i);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());

        for(int i=0;i<testCnt;i++) {
            int n = Integer.parseInt(br.readLine());
            result.append(zeroCntArr[n]).append(' ').append(oneCntArr[n]).append('\n');
        }
        br.close();

        System.out.println(result);
    }

    private static void fibonacci(int n) {
        zeroCntArr[n] = zeroCntArr[n-1] + zeroCntArr[n-2];
        oneCntArr[n] = oneCntArr[n-1] + oneCntArr[n-2];
    }
}
