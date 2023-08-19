package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2170 (선 긋기)
 * @classfication: Greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.08.19 (O)
 **/
public class Q2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineCnt = Integer.parseInt(br.readLine());
        int[][] lines = new int[lineCnt][2];
        StringTokenizer st;

        for(int i=0;i<lineCnt;i++) {
            st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(lines, (l1, l2) -> l1[0] - l2[0]);

        int sumLine = 0, minX = lines[0][0], maxY = lines[0][1];

        for(int i=1;i<lines.length;i++) {
            int x = lines[i][0];
            int y = lines[i][1];

            if(maxY < x) {
                sumLine += maxY - minX;
                minX = x;
                maxY = y;
            } else {
                maxY = Math.max(maxY, y);
            }
        }

        sumLine += maxY - minX;

        System.out.print(sumLine);
    }
}
