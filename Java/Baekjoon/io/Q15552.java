package Baekjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15552 (빠른 A+B)
 * @classfication: 입출력
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.12.28 (O)
 **/
public class Q15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            result.append(A+B).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
