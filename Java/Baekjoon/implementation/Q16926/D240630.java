package Baekjoon.implementation.Q16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16926 (배열 돌리기 1)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.06.30 (O)
 * memory: 28504KB, time: 532ms
 **/
public class D240630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        int depth = Math.min(n, m) / 2;
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                int num = Integer.parseInt(st.nextToken());
                arr1[i][j] = num;
                arr2[i][j] = num;
            }
        }

        br.close();

        for(int i=0;i<depth;i++) {
            int rotation = r % 2 * (n+m-2-(4*i));

            for(int j=i;j<n-i;j++) {
                for(int k=i;k<m-i;k++) {
                    if(j == i || j == n-i-1 || k == i || k == m-i-1) {
                        int copyR = rotation;
                        int x = j, y = k;

                        while(copyR-- > 0) {
                            if(x < n-i-1 && y == i) {
                                ++x;
                            } else if(x == n-i-1 && y < m-i-1) {
                                ++y;
                            } else if(x > i && y == m-i-1) {
                                --x;
                            } else if(x == i && y > i) {
                                --y;
                            }
                        }

                        arr2[x][y] = arr1[j][k];
                    }
                }
            }
        }

        for(int[] arr : arr2) {
            for(int i : arr) {
                result.append(i).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
