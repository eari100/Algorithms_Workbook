package Baekjoon.divisionAndConquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1074 (Z)
 * @classfication: division-and-conquest
 * @문제 푼 날짜 (자력으로 풂?): 23.04.21 (X, 분할정복 아이디어는 떠올렸으나 최적화를 못함)
 **/
public class Q1074 {
    static int visitedOrder = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2, N);

        process(r, c, length);
        System.out.print(visitedOrder);
    }

    private static void process(int r, int c, int length) {
        if(length == 1)
            return;

        if(r < length/2 && c < length/2) {
            process(r, c, length/2);
        } else if(r < length/2 && c >= length/2) {
            visitedOrder += length * length / 4;
            process(r, c - length/2, length/2);
        } else if(r >= length/2 && c < length/2) {
            visitedOrder += (length * length / 4) * 2 ;
            process(r - length/2, c, length/2);
        } else if(r >= length/2 && c>= length/2) {
            visitedOrder += (length * length / 4) * 3;
            process(r - length/2 , c - length/2, length/2);
        }
    }
}
