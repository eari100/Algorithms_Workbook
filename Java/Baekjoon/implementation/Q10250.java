package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10250 (ACM 호텔)
 * @classfication: implementation, math
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (O)
 **/
public class Q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer data = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(data.nextToken());
            int W = Integer.parseInt(data.nextToken());
            int N = Integer.parseInt(data.nextToken());

            int roomNumber = getRoomNumber(N, H);

            result.append(roomNumber).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static int getRoomNumber(int N, int H) {
        int share = N / H;
        int remain = N % H;
        return (remain == 0) ? H * 100 + share : remain * 100 + share + 1;
    }
}