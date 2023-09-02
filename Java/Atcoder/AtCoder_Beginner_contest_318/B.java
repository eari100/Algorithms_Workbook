package Atcoder.AtCoder_Beginner_contest_318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc318/tasks/abc318_b (B - Overlapping sheets)
 * @classfication: implementation, geometry
 * @문제 푼 날짜 (자력으로 풂?): 23.09.02 (O)
 **/
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[101][101];
        int result = 0;

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=y1;j<y2;j++) {
                for(int k=x1;k<x2;k++) {
                    boolean visited = board[j][k];

                    if( !visited ) {
                        ++result;
                        board[j][k] = true;
                    }
                }
            }
        }

        br.close();

        System.out.print(result);
    }
}
