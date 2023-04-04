package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/23971 (ZOAC 4)
 * @classfication: math
 * @문제 푼 날짜 (자력으로 풂?): 23.04.05 (O)
 **/
public class Q23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken()) + 1;

        System.out.println(((H / N) + (H % N > 0 ? 1 : 0)) * ((W / M) + (W % M > 0 ? 1 : 0)));
    }
}
