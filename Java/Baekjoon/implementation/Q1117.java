package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1117 (색칠 1)
 * @classfication: implementation, math
 * @문제 푼 날짜 (자력으로 풂?): 23.09.28 (O, 큰 수 연산 W*H 조심)
 **/
// todo: 깔끔한 공식으로 정리할 것
public class Q1117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        long paintingCount = 0;

        int pieceX1 = W == f ? 0 : f;

        long area1 = 0;
        long area2 = 0;

        int gap = 0;

        if(f > 0 && f < W) {
            gap += (x2-x1) + (x1*2);
        }

        for(int x=pieceX1+x1;x<pieceX1+x2;x++) {
            ++area1;

            if(gap > 0 && x >= 0 && x < W) {
                if(x-gap >= 0 && x-gap < W) {
                    ++area2;
                }
            }
        }

        paintingCount += area1*(y2-y1) + area2*(y2-y1);

        if(c > 0)
            paintingCount *= (c+1);

        System.out.println(((long)W*H) - paintingCount);
    }
}
